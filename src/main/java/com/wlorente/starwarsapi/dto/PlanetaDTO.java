package com.wlorente.starwarsapi.dto;

import java.io.Serializable;

import com.wlorente.starwarsapi.domain.Planeta;

public class PlanetaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private int qtde_aparicoes;
	
	public PlanetaDTO() {
		
	}
	
	public PlanetaDTO(Planeta obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.clima = obj.getClima();
		this.terreno = obj.getTerreno();
		this.qtde_aparicoes = obj.getQtde_aparicoes();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getQtde_aparicoes() {
		return qtde_aparicoes;
	}

	public void setQtde_aparicoes(int qtde_aparicoes) {
		this.qtde_aparicoes = qtde_aparicoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	

}
