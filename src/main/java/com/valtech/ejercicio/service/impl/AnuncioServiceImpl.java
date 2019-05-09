package com.valtech.ejercicio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.ejercicio.entity.Anuncio;
import com.valtech.ejercicio.repository.AnuncioJpaRepository;
import com.valtech.ejercicio.service.AnuncioService;

@Service
public class AnuncioServiceImpl implements AnuncioService {

	@Autowired
	private AnuncioJpaRepository anuncioJpaRepository;

	private final Log LOG = LogFactory.getLog(AnuncioServiceImpl.class);

	@Override
	public List<Anuncio> listAnuncios() {
		LOG.info("Ingresé al metodo listAnuncios dentro de AnuncioServiceImpl");
		return anuncioJpaRepository.findAll();
	}

	@Override
	public Anuncio findById(Long id) throws NoSuchElementException {
		LOG.info("Ingresé al metodo findById dentro de AnuncioServiceImpl con el parametro " + id);
		return anuncioJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Anuncio doesn't exist with id: " + id));
	}

	@Override
	public Anuncio save(Anuncio anuncio) {
		LOG.info("Ingresé al metodo save dentro de AnuncioServiceImpl con el parametro " + anuncio.toString());
		return anuncioJpaRepository.save(anuncio);
	}

	@Override
	public boolean delete(Long id) {
		LOG.info("Ingresé al metodo delete dentro de AnuncioServiceImpl con el parametro " + id);
		Anuncio anuncio = anuncioJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Anuncio doesn't exist with id: " + id));

		if (anuncio != null) {
			anuncioJpaRepository.delete(anuncio);
			return true;
		} else {
			return false;
		}

	}

}
