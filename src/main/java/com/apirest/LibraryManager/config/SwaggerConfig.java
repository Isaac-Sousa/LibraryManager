package com.apirest.LibraryManager.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
    //springdoc.swagger-ui.path=/api/swagger-ui.html

    private static final String BASE_PACKAGE = "com.apirest.LibraryManager";
    private static final String TITLE = "Library Manager";
    private static final String DESCRIPTION = "Initial api";
    private static final String VERSION ="1.0.0";
    private static final String CONTACT_NAME = "Isaac de Sousa";
    private static final String CONTACT_GITHUB = "https://github.com/Isaac-Sousa";
    private static final String CONTACT_EMAIL = "isaacsousadev@gmail.com";


    @Bean
    public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2)
      .select()
              .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
              .paths(PathSelectors.any())
              .build()
              .apiInfo(buildApiInfo())
              .pathMapping("/");
    }
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME,CONTACT_GITHUB,CONTACT_EMAIL))
                .build();
    }
}
