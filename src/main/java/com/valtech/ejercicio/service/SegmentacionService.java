package com.valtech.ejercicio.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.valtech.ejercicio.entity.Segmentacion;

public interface SegmentacionService {
	public abstract List<Segmentacion> listSegmentacion();

	public abstract Segmentacion findById(Long id) throws NoSuchElementException;

	public abstract Segmentacion save(Segmentacion segmentacion);

	public abstract boolean delete(Long id);
}
