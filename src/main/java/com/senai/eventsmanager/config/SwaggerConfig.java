package com.senai.eventsmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI eventsManagerOpenAPI(){
        return new OpenAPI()
        .info(new Info()
        .title("Events Manager API")
        .version("1.0.0")
        .description("Sistema de gerenciamento de eventos")
        .contact(new Contact().name("Kamila Souza").email("kskamila39@gmail.com")));
    }

}
