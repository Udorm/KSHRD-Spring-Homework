package com.kshrd.configurations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kshrd.repositories")
public class H2DatabaseConfiguration {
	
}
