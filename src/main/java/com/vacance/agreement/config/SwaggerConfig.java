package com.vacance.agreement.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final String API_NAME = "Vacance-Agreement  API";
	private static final String API_VERSION = "0.1";
	private static final String API_DESCRIPTION = "Vacance-Agreement API 명세서";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
			.securityContexts(Collections.singletonList(securityContext()))
			.securitySchemes(List.of(apiKey()))
			.useDefaultResponseMessages(false)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.vacance.agreement.api"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
			.securityReferences(defaultAuth())
			.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return List.of(new SecurityReference("Authorization", authorizationScopes));
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title(API_NAME)
			.version(API_VERSION)
			.description(API_DESCRIPTION)
			.build();
	}
}
