package com.cobranca.CarteiraCobranca.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public BCryptPasswordEncoder senhaEncoder() {
		BCryptPasswordEncoder senhaEncoder = new BCryptPasswordEncoder();
		return senhaEncoder;
	}
}
