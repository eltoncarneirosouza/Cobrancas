package com.cobranca.CarteiraCobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView view = new ModelAndView();
		view.setViewName("login/login");
		return view;
	}
}
