package ru.gloria_jeans.receiving;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.util.Optional;

@ComponentScan("ru.gloria_jeans")
@SpringBootApplication
@OpenAPIDefinition(
        tags = {@Tag(name="Приемка товара")},
        info = @Info(
                title = "Gloria Jeans :: Приемка товара",
                version = "1.0"
        )
)
public class ReceivingApplication {
    @Autowired
    BuildProperties buildProperties;

    public static void main(String[] args) {
        setDefaultConfiguration();
        SpringApplication.run(ReceivingApplication.class, args);
    }

    public static void setDefaultConfiguration() {
        try {
            System.setProperty("hostname", InetAddress.getLocalHost().getHostName());
            System.out.printf("Service set hostname '%s'.%n", InetAddress.getLocalHost().getHostName());
        } catch (Exception exception) {
            System.setProperty("hostname", "localhost");
            System.out.println("System can not get hostname of local machine and set 'localhost'.");
        }
    }

    /*
    Capturing Micrometer metrics with the OpenTelemetry Java instrumentation agent almost works out of the box:
    The agent detects Micrometer and registers an OpenTelemetryMeterRegistry on the fly.
    Unfortunately the agent registers with Micrometer’s Metrics.globalRegistry, while Spring uses its own registry
    instance via dependency injection. If the OpenTelemetryMeterRegistry ends up in the wrong MeterRegistry instance,
    it is not used by Spring.
    In order to fix this, we need to make OpenTelemetry’s OpenTelemetryMeterRegistry available as a Spring bean,
    so that Spring can register it correctly when it sets up dependency injection.
*/
    @Bean
    @ConditionalOnClass(name = "io.opentelemetry.javaagent.OpenTelemetryAgent")
    public MeterRegistry otelRegistry() {
        Optional<MeterRegistry> otelRegistry = Metrics.globalRegistry.getRegistries().stream()
                .filter(r -> r.getClass().getName().contains("OpenTelemetryMeterRegistry"))
                .findAny();
        otelRegistry.ifPresent(Metrics.globalRegistry::remove);
        return otelRegistry.orElse(null);
    }

    @PostConstruct
    public void displayVersion() {
        System.out.printf("Application version: %s\n", buildProperties.getVersion());
    }
}

