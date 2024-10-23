package org.example.bebyundohwi.week1.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private static final String API_NAME = "Task Mng API";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION  = "Task Mng API Description";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("groupName")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Hello Swagger")
                .description("스웨거 기능 테스트")
                .version("1.0")
                .build();
    }
}
