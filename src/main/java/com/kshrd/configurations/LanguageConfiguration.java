package com.kshrd.configurations;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LanguageConfiguration extends WebMvcConfigurerAdapter{
	
	//Set parameter for changing language
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		LocaleChangeInterceptor tr = new LocaleChangeInterceptor();
		tr.setParamName("lang");
		return tr;
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(localeChangeInterceptor());
	}
	
	//Set Default language
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver sr = new SessionLocaleResolver();
		sr.setDefaultLocale(new Locale("kh"));
		//sr.setDefaultLocale(new Locale("kh"));
		return sr;
	}
	
	//Map message locations
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("i18n/staticContent/messages", "i18n/validations/validations");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}
}
