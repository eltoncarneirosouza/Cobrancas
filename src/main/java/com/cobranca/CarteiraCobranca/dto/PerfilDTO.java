package com.cobranca.CarteiraCobranca.dto;

import com.cobranca.CarteiraCobranca.model.Perfil;

public class PerfilDTO {

	private long id;
	private String descricao;

	public PerfilDTO(Perfil perfil) {
		this.id = perfil.getId();
		this.descricao = perfil.getDescricao();
	}

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
