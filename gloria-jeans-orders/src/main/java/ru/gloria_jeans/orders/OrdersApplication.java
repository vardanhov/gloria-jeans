package ru.gloria_jeans.orders;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.InetAddress;
import java.util.Optional;

@ComponentScan("ru.gloria_jeans")
@SpringBootApplication
public class OrdersApplication {
    @Autowired
    BuildProperties buildProperties;

    public static void main(String[] args) {
        setDefaultConfiguration();
        SpringApplication.run(OrdersApplication.class, args);
    }

    public static void setDefaultConfiguration() {
        try {
            System.setProperty("hostname", InetAddress.getLocalHost().getHostName());
            System.out.printf("Service set hostname '%s'.\n", InetAddress.getLocalHost().getHostName());
        } catch (Exception exception) {
            System.setProperty("hostname", "localhost");
            System.out.println("System can not get hostname of local machine and set 'localhost'.");
        }
    }


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

