package org.company.belili.springbootjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String resourcePath = Paths.get("uploads").toAbsolutePath().toUri().toString();
        logger.info(resourcePath);

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations(resourcePath);
    }
}
