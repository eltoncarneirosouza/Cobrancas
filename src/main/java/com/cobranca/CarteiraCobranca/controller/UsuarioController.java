package com.cobranca.CarteiraCobranca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cobranca.CarteiraCobranca.dto.LogadoDTO;
import com.cobranca.CarteiraCobranca.dto.UsuarioDTO;
import com.cobranca.CarteiraCobranca.form.UsuarioForm;
import com.cobranca.CarteiraCobranca.model.Perfil;
import com.cobranca.CarteiraCobranca.model.Usuario;
import com.cobranca.CarteiraCobranca.repository.PerfilRepository;
import com.cobranca.CarteiraCobranca.repository.UsuarioRepository;
import com.cobranca.CarteiraCobranca.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView lista(
			@PageableDefault(direction = Direction.DESC, page = 0, size = 5, sort = "id") Pageable pageable) {
		LogadoDTO logados = UsuarioService.preencherLogados();
		Page<Usuario> page = usuarioRepository.findAll(pageable);
		Page<UsuarioDTO> pageDTO = UsuarioDTO.converter(page);
		ModelAndView view = new ModelAndView();
		view.setViewName("usuario/usuario");
		view.addObject("logados", logados); 
		view.addObject("usuario", new UsuarioForm());
		view.addObject("usuarios", pageDTO);
		return view;
	}

	@ModelAttribute("addPerfil")
	public List<Perfil> addPerfil() {
		return perfilRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(UsuarioForm form) {
		long codigoPerfil = form.getPerfil();
		Optional<Perfil> perfil = perfilRepository.findById(codigoPerfil);

		Usuario usuario = form.converter(perfil.get());
		ModelAndView view = new ModelAndView();
		try {
			usuarioService.salvar(usuario);
			view.setViewName("redirect:/usuario");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return view;

	}
}
