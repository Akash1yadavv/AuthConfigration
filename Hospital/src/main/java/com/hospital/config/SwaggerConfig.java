package com.hospital.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

//@Configuration
public class SwaggerConfig {

//    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("HAARMK")
                .pathsToMatch("/","/**").build();
    }

//    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("spinnyhost API")
                        .description("A host solution")
                        .version("v0")
                        .license(new License().name("").url("https://spinnyhost.com")))
                .externalDocs(new ExternalDocumentation()
//	              .description("SpringShop Wiki Documentation")
                        .url("https://api.v0.spinnyhost.com"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("Bearer").bearerFormat("JWT")))
//	              .components(new Components().addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                ;
    }
}
