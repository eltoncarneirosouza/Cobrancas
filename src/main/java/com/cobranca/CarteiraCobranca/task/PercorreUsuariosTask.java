package com.cobranca.CarteiraCobranca.task;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.cobranca.CarteiraCobranca.model.Usuario;
import com.cobranca.CarteiraCobranca.repository.UsuarioRepository;

@Configuration
@EnableScheduling
public class PercorreUsuariosTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(PercorreUsuariosTask.class);
	@Autowired
	private UsuarioRepository repository;

	@Scheduled(fixedDelay = 86400000)
	public void scheduleFixedDelayTask() {
		List<Usuario> list = repository.findAll();
		if (list.isEmpty() || list == null) {
			LOGGER.info("=====================================");
			LOGGER.info("Sem usuários cadastrados no sistemas");
			LOGGER.info("=====================================");
		} else {
			LOGGER.info("=====================================");
			LOGGER.info("usuários cadastros no sistema: " + list.size());
			LOGGER.info("=====================================");
		}

	}
}
