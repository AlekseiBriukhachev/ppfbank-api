package com.aleksei.ppfbankapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "PPF Bank API",
                version = "1.0",
                description = "API for retrieving bank account information"
        )
)
public class OpenApiConfig {
}
