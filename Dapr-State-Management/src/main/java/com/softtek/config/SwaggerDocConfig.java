package com.softtek.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocConfig {

	@Bean
	public Docket createDockect() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.softtek.controller")).build()
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());

	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Softtek", "https://www.softtek.com", "webmaster@softtek.com");
		return new ApiInfo("Softtek ", " Infomation About Softtek", "3.4.RELEASE", "https://www.softtek.com", contact,
				"GNU Public", "http://apache.org/license/gnu", Collections.emptyList());
	}

}
