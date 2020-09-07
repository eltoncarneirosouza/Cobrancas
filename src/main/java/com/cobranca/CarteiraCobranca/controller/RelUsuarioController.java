package com.cobranca.CarteiraCobranca.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cobranca.CarteiraCobranca.dto.LogadoDTO;
import com.cobranca.CarteiraCobranca.service.UsuarioService;
import com.cobranca.CarteiraCobranca.util.GeradorRelatorios;

@Controller
@RequestMapping("relUsuarios")
public class RelUsuarioController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RelUsuarioController.class);
	@Autowired
	private DataSource dataSource;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		LogadoDTO logados = UsuarioService.preencherLogados();
		ModelAndView view = new ModelAndView();
		view.setViewName("relatorioUsuarios/rel_usuario");
		view.addObject("logados", logados);
		return view;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doPost(HttpServletResponse response) {
		try {
			String caminho = "jasper/usuarios.jrxml";
			String relatorio = "usuarios.pdf";
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			Connection connection = dataSource.getConnection();

			GeradorRelatorios relatorios = new GeradorRelatorios(caminho, relatorio);
			relatorios.gerandoPDF(response, connection, parametros);
		} catch (SQLException e) {
			LOGGER.info("Erro: " + e.getMessage());
		}
		return null;
	}
}
