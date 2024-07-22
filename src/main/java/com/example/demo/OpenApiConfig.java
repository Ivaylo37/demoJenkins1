package com.example.demo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Demo",
                description = "A simple and intentionally flawed spring boot project."
                ),
        servers = @Server(url = "${springdoc.swagger-ui.server}")
)


public class OpenApiConfig {
}
