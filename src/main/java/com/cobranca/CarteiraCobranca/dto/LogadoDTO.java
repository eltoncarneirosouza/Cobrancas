package com.cobranca.CarteiraCobranca.dto;

import java.util.List;

import com.cobranca.CarteiraCobranca.model.Perfil;
import com.cobranca.CarteiraCobranca.model.Usuario;

public class LogadoDTO {
	private long id;
	private String email;
	private String nome;
	private List<Perfil> perfil;

	public LogadoDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
		this.perfil = usuario.getRoles();
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}

	@Override
	public String toString() {
		return "Logados[email=" + email + ", nome=" + nome + "]";
	}

}
