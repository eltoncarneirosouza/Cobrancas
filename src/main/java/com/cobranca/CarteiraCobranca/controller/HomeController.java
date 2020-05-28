package com.cobranca.CarteiraCobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista() {
		ModelAndView view = new ModelAndView();
		view.setViewName("home/home");
		return view;
	}
}
