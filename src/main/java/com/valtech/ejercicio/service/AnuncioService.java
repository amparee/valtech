package com.valtech.ejercicio.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.valtech.ejercicio.entity.Anuncio;
import com.valtech.ejercicio.model.AnuncioModel;

public interface AnuncioService {
	public abstract List<AnuncioModel> listAnuncios();

	public abstract AnuncioModel findById(Long id) throws NoSuchElementException;

	public abstract AnuncioModel save(Anuncio anuncio);

	public abstract boolean delete(Long id);
}
