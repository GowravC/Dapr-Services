package com.register.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Swagger configuration for register service project
 * 
 * @author gowrav.c
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.register.controller")).build()
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {

		Contact contact = new Contact("Softtek", "https://www.softtek.com", "webmaster@softtek.com");

		return new ApiInfo("Register API ",
				" Information About Register Service for all required consumables - Dairy products, power consumption, IT assets etc.\n"
						+ "The register helps users to avoid manual paper works by digitizing their front desk and saves millions of trees on a yearly basis.",
				"5.5.Release", "https://www.softtek.com", contact, "GNU Public", "http://apache.org/licence/gnu",
				Collections.emptyList());
	}

}
