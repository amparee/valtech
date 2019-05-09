package com.valtech.ejercicio.model;

import java.util.List;

import com.valtech.ejercicio.entity.Anuncio;

public class SegmentacionModel {

	private String tipo;
	private String pais;
	private int edad;
	private String genero;
	private List<Anuncio> anuncios;

	public SegmentacionModel() {
	}

	public SegmentacionModel(String tipo, String pais, int edad, String genero, List<Anuncio> anuncios) {
		this.tipo = tipo;
		this.pais = pais;
		this.edad = edad;
		this.genero = genero;
		this.anuncios = anuncios;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
