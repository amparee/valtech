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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id")
	private Long id;

	private String username;
	private String password;
	private String pais;
	private int edad;
	private String genero;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id", fetch = FetchType.LAZY)
	private List<Anuncio> anuncios;

	public Usuario() {
	}

	public Usuario(Long id, String username, String password, String pais, int edad, String genero,
			List<Anuncio> anuncios) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.pais = pais;
		this.edad = edad;
		this.genero = genero;
		this.anuncios = anuncios;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", pais=" + pais + ", edad="
				+ edad + ", genero=" + genero + ", anuncios=" + anuncios + "]";
	}

}
