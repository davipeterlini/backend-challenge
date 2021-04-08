package com.itidigital.validator.api.common

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author Davi Peterlini
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket = Docket(DocumentationType.OAS_30)
        .select()
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
        .paths(PathSelectors.any())
        .build()
}