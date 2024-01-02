package com.hospital.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(contact = @Contact(name = "spinnyhost", email = "info@haarmk.com", url = "https:spinnyhost.com"), description = "OpenApi documentation for SpinnyHost", title = "SpinnyHost API", version = "0.0", license = @License(name = "not mit"), termsOfService = "terms of service"

)
, servers = {@Server(description = "Default Server URL", url = "/"), @Server(description = "dev", url = "http://localhost:8080"),
		@Server(description = "prod", url = "https://api.v0.spinnyhost.com")}

)
@SecurityScheme(name = "bearer-key", description = "jwt auth", scheme = "Bearer", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", in = SecuritySchemeIn.HEADER)
@Configuration
public class OpenApiConf {

}
