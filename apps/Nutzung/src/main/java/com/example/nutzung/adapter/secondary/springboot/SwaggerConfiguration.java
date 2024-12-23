package com.example.nutzung.adapter.secondary.springboot;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SwaggerConfiguration {

        @Bean
        public OpenAPI customOpenAPI() {
                Server server = new Server()
                                .url("http://localhost:8082")
                                .description("Ladenutzungsverwaltungs-API");

                return new OpenAPI()
                                .servers(Arrays.asList(server))
                                .info(new io.swagger.v3.oas.models.info.Info()
                                                .title("LadenLeichtGemacht API")
                                                .description(
                                                                "API für die Verwaltung der Ladenutzung bei LadenLeichtGemacht")
                                                .version("1.0.0"));
        }
}
