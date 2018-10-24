package com.recp.recpbooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
//                .host(baseUrl)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "RS Booking service",
                "RS Booking Control Panel service REST API Documentation.",
                "API TOS",
                "http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open",
                new Contact("Software Team", "Dev Team", "roshan2signup@gmail.com"),
                "Apache License Version 2.0", "https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE",
                Collections.emptyList());
    }


}
