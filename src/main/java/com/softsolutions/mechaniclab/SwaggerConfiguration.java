package com.softsolutions.mechaniclab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).produces(new HashSet<>(Collections.singletonList("application/json"))).apiInfo(metaData());
    }


    private ApiInfo metaData() {
        return new ApiInfo(
                "Mechanic's Lab Rest API",
                "Restful interface of Mechanic's Lab",
                "1.0",
                "Terms of service",
                new Contact("Johnn Guerrero", "url", "john6832@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
    }
}
