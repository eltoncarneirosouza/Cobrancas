package com.cobranca.CarteiraCobranca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CarteiraCobrancaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarteiraCobrancaApplication.class, args);
		System.out.println("senha-->"+new BCryptPasswordEncoder().encode("123456"));
	}

}
