package com.valtech.ejercicio.model;

import java.time.LocalDate;

import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.entity.Usuario;

public class AnuncioModel {

	private double costoPorImpresion;
	private double costoMaximo;
	private LocalDate fechaFin;
	private Segmentacion segmentacion;
	private Usuario usuario;

	public AnuncioModel() {
	}

	public AnuncioModel(double costoPorImpresion, double costoMaximo, LocalDate fechaFin, Segmentacion segmentacion,
			Usuario usuario) {
		this.costoPorImpresion = costoPorImpresion;
		this.costoMaximo = costoMaximo;
		this.fechaFin = fechaFin;
		this.segmentacion = segmentacion;
		this.usuario = usuario;
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

}
