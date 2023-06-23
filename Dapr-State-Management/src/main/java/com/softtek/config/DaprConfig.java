package com.softtek.config;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaprConfig {

    @Bean
    DaprClient getClient() {
        return (new DaprClientBuilder()).build();
    }

}
