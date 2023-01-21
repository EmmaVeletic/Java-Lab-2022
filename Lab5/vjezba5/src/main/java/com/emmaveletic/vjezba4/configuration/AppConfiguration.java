package com.emmaveletic.vjezba4.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	

}
