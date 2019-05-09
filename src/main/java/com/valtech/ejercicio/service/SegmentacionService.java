package com.valtech.ejercicio.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.model.SegmentacionModel;

public interface SegmentacionService {
	public abstract List<SegmentacionModel> listSegmentacion();

	public abstract SegmentacionModel findById(Long id) throws NoSuchElementException;

	public abstract SegmentacionModel save(Segmentacion segmentacion);

	public abstract boolean delete(Long id);
}
