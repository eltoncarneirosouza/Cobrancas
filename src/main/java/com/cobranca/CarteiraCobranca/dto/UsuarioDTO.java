package com.cobranca.CarteiraCobranca.dto;

import java.util.List;
import org.springframework.data.domain.Page;

import com.cobranca.CarteiraCobranca.model.Perfil;
import com.cobranca.CarteiraCobranca.model.Usuario;

public class UsuarioDTO {

	private long id;
	private String email;
	private String senha;
	private String nome;
	private String ativo;
	private List<Perfil> perfil;

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.nome = usuario.getNome();
		this.ativo = usuario.getAtivoDescricao();
		this.perfil = usuario.getRoles();
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public List<Perfil> getPerfil() {
		return perfil;
	}

	public static Page<UsuarioDTO> converter(Page<Usuario> page) {
		return page.map(UsuarioDTO::new);
	}

}
