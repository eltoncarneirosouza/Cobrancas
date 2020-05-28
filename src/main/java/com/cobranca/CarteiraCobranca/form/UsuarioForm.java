package com.cobranca.CarteiraCobranca.form;

import java.util.ArrayList;
import java.util.List;

import com.cobranca.CarteiraCobranca.model.Perfil;
import com.cobranca.CarteiraCobranca.model.Usuario;

public class UsuarioForm {

	private String email;
	private String senha;
	private String nome;
	private long perfil;
	private boolean ativo;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPerfil() {
		return perfil;
	}

	public void setPerfil(long perfil) {
		this.perfil = perfil;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario converter(Perfil perfils) {
		List<Perfil> perfil = new ArrayList<Perfil>();
		perfil.add(perfils);
		return new Usuario(this.email, this.senha, this.nome, this.ativo, perfil);
	}
}
