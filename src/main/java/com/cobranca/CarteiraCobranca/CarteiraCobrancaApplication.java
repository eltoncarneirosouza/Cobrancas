package com.cobranca.CarteiraCobranca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarteiraCobrancaApplication {

	private static Logger logger = LoggerFactory.getLogger(CarteiraCobrancaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CarteiraCobrancaApplication.class, args);
		logger.info("====Inicializando o sistema====");
	}

}
