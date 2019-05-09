package com.valtech.ejercicio.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Segmentacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "segmentacion_id")
	private Long id;

	private String tipo;
	private String pais;
	private int edad;
	private String genero;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
	private List<Anuncio> anuncios;

	public Segmentacion() {
	}

	public Segmentacion(Long id, String tipo, String pais, int edad, String genero) {
		this.id = id;
		this.tipo = tipo;
		this.pais = pais;
		this.edad = edad;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Segmentacion [id=" + id + ", tipo=" + tipo + ", pais=" + pais + ", edad=" + edad + ", genero=" + genero
				+ ", anuncios=" + anuncios + "]";
	}

}
