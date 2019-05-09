package com.valtech.ejercicio.converter;

import org.springframework.stereotype.Component;

import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.model.SegmentacionModel;

@Component("segmentacionConverter")
public class SegmentacionConverter {

	public static SegmentacionModel convertSegmentacionToSegmentacionModel(Segmentacion segmentacion) {

		SegmentacionModel segmentacionModel = new SegmentacionModel();
		segmentacionModel.setAnuncios(segmentacion.getAnuncios());
		segmentacionModel.setEdad(segmentacion.getEdad());
		segmentacionModel.setGenero(segmentacion.getGenero());
		segmentacionModel.setPais(segmentacion.getPais());
		segmentacionModel.setTipo(segmentacion.getTipo());
		return segmentacionModel;

	}

	public static Segmentacion convertSegmentacionModelToSegmentacion(SegmentacionModel segmentacionModel) {

		Segmentacion segmentacion = new Segmentacion();
		segmentacion.setAnuncios(segmentacionModel.getAnuncios());
		segmentacion.setEdad(segmentacionModel.getEdad());
		segmentacion.setGenero(segmentacionModel.getGenero());
		segmentacion.setPais(segmentacionModel.getPais());
		segmentacion.setTipo(segmentacionModel.getTipo());
		return segmentacion;

	}

}
