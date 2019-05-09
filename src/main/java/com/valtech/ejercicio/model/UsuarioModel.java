package com.valtech.ejercicio.model;

import java.util.List;

import com.valtech.ejercicio.entity.Anuncio;

public class UsuarioModel {

	private String username;
	private String password;
	private String pais;
	private int edad;
	private String genero;
	private List<Anuncio> anuncios;

	public UsuarioModel() {
	}

	public UsuarioModel(String username, String password, String pais, int edad, String genero,
			List<Anuncio> anuncios) {
		this.username = username;
		this.password = password;
		this.pais = pais;
		this.edad = edad;
		this.genero = genero;
		this.anuncios = anuncios;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

}
