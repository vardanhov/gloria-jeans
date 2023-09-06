package ru.gloria_jeans.ui.server;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class UTConfiguration {
    @Bean
    public MeterRegistry registry() {
        return new SimpleMeterRegistry();
    }
}
