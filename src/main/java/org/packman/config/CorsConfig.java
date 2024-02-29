package org.packman.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Profile("develop")
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    private final WebProperties webProperties;

    public CorsConfig(WebProperties webProperties) {
        this.webProperties = webProperties;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v2/**")
                .allowedOrigins(webProperties.allowedOrigins().toArray(String[]::new))
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(1800);
    }
}
