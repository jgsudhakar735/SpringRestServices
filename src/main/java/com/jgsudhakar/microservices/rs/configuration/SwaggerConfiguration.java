/**
 * 
 */
package com.jgsudhakar.microservices.rs.configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sudhakar.t
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final Contact DEFAULT_CONTACT = new Contact("Sudhakar", "www.xyz.com", "xyz@gmail.com");;
	private static final ApiInfo DEFAULT_API_INFO =  new ApiInfo("Spring Rest Service", "Spring Documentation", "1.0", "",
	          DEFAULT_CONTACT, "TagIt", "http://www.tagitmobile.com");
	private static final Set<String> DEFAULT_PRODUCE = new HashSet<String>(Arrays.asList("application/json","application/xml"));
	private static final Set<String> DEFAULT_CONSUME = new HashSet<String>(Arrays.asList("application/json"));;

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(DEFAULT_API_INFO).
				produces(DEFAULT_PRODUCE).
				consumes(DEFAULT_CONSUME);
	}
}
