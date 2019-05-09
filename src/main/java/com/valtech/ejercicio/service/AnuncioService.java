package com.valtech.ejercicio.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.valtech.ejercicio.entity.Anuncio;

public interface AnuncioService {
	public abstract List<Anuncio> listAnuncios();

	public abstract Anuncio findById(Long id) throws NoSuchElementException;

	public abstract Anuncio save(Anuncio anuncio);

	public abstract boolean delete(Long id);
}
