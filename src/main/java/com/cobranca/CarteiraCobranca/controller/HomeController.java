package com.cobranca.CarteiraCobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cobranca.CarteiraCobranca.dto.LogadoDTO;
import com.cobranca.CarteiraCobranca.service.UsuarioService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		LogadoDTO logados = UsuarioService.preencherLogados();
		ModelAndView view = new ModelAndView();
		view.setViewName("home/home");
		view.addObject("logados", logados);
		return view;
	}
}
