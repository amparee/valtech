package com.valtech.ejercicio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "anuncio_id")
	private Long id;

	private double costoPorImpresion;

	private double costoMaximo;

	private LocalDate fechaFin;

	@JoinColumn(name = "segmentacion", referencedColumnName = "segmentacion_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Segmentacion segmentacion;

	@JoinColumn(name = "usuario", referencedColumnName = "usuario_id")
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Usuario usuario;

	public Anuncio() {
	}

	public Anuncio(Long id, double costoPorImpresion, double costoMaximo, LocalDate fechaFin, Segmentacion segmentacion,
			Usuario usuario) {
		this.id = id;
		this.costoPorImpresion = costoPorImpresion;
		this.costoMaximo = costoMaximo;
		this.fechaFin = fechaFin;
		this.segmentacion = segmentacion;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCostoPorImpresion() {
		return costoPorImpresion;
	}

	public void setCostoPorImpresion(double costoPorImpresion) {
		this.costoPorImpresion = costoPorImpresion;
	}

	public double getCostoMaximo() {
		return costoMaximo;
	}

	public void setCostoMaximo(double costoMaximo) {
		this.costoMaximo = costoMaximo;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Segmentacion getSegmentacion() {
		return segmentacion;
	}

	public void setSegmentacion(Segmentacion segmentacion) {
		this.segmentacion = segmentacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Anuncio [id=" + id + ", costoPorImpresion=" + costoPorImpresion + ", costoMaximo=" + costoMaximo
				+ ", fechaFin=" + fechaFin + ", segmentacion=" + segmentacion + ", usuario=" + usuario + "]";
	}

}
