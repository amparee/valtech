package com.valtech.ejercicio.converter;

import org.springframework.stereotype.Component;

import com.valtech.ejercicio.entity.Anuncio;
import com.valtech.ejercicio.model.AnuncioModel;

@Component("anuncioConverter")
public class AnuncioConverter {

	public static AnuncioModel convertAnuncioToAnuncioModel(Anuncio anuncio) {

		AnuncioModel anuncioModel = new AnuncioModel();
		anuncioModel.setCostoMaximo(anuncio.getCostoMaximo());
		anuncioModel.setCostoPorImpresion(anuncio.getCostoPorImpresion());
		anuncioModel.setFechaFin(anuncio.getFechaFin());
		anuncioModel.setSegmentacion(anuncio.getSegmentacion());
		anuncioModel.setUsuario(anuncio.getUsuario());
		return anuncioModel;

	}

	public static Anuncio convertAnuncioModelToAnuncio(AnuncioModel anuncioModel) {

		Anuncio anuncio = new Anuncio();
		anuncio.setCostoMaximo(anuncioModel.getCostoMaximo());
		anuncio.setCostoPorImpresion(anuncioModel.getCostoPorImpresion());
		anuncio.setFechaFin(anuncioModel.getFechaFin());
		anuncio.setSegmentacion(anuncioModel.getSegmentacion());
		anuncio.setUsuario(anuncioModel.getUsuario());
		return anuncio;

	}

}
