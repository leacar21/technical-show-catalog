package com.leacar21.technical.show.catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leacar21.technical.show.catalog.controllers.SectionSeatController;
import com.leacar21.technical.show.catalog.controllers.ShowCatalogController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        var docket = new Docket(DocumentationType.SWAGGER_2);
        return docket.select()
                     .apis(RequestHandlerSelectors.any())
                     .paths(PathSelectors.ant("/" + ShowCatalogController.SHOWS_RESOURCE)
                                         .or(PathSelectors.ant("/" + SectionSeatController.SECTION_SEAT_RESOURCE)))
                     .build();
    }
}
