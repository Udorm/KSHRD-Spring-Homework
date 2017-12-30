package com.kshrd.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileUploadConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Config file upload");
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("file:/Users/udormphon/Desktop/");
	}
}
