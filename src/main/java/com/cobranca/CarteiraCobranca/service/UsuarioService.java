package com.cobranca.CarteiraCobranca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cobranca.CarteiraCobranca.model.Usuario;
import com.cobranca.CarteiraCobranca.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder senhaEncoder;

	public Optional<Usuario> encontrar(String email) {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		return usuario;
	}

	public void salvar(Usuario usuario) throws Exception {
		Optional<Usuario> usuarioExistente = encontrar(usuario.getEmail());
		if (usuarioExistente.isPresent()) {
			throw new Exception("E-mail já existente");
		} else {
			usuario.setSenha(senhaEncoder.encode(usuario.getSenha()));
			usuarioRepository.save(usuario);
		}
	}
}
