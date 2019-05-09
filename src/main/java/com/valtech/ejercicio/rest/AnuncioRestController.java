package com.valtech.ejercicio.rest;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.ejercicio.entity.Anuncio;
import com.valtech.ejercicio.service.AnuncioService;
import com.valtech.ejercicio.service.impl.AnuncioServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/anuncio")
public class AnuncioRestController {

	@Autowired
	private AnuncioService anuncioService;

	private final Log LOG = LogFactory.getLog(AnuncioServiceImpl.class);

	@GetMapping("/get-anuncios")
	public ResponseEntity<List<Anuncio>> getAnuncios() {
		LOG.info("Ingresé al metodo getAnuncios dentro de AnuncioRestController");
		return new ResponseEntity<List<Anuncio>>(anuncioService.listAnuncios(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAnuncioById(@PathVariable("id") Long id) {
		LOG.info("Ingresé al metodo getAnuncioById dentro de AnuncioRestController con el parametro " + id);
		try {
			Anuncio anuncio = anuncioService.findById(id);
			return new ResponseEntity<Anuncio>(anuncio, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Anuncio> createAnuncio(@RequestBody Anuncio anuncio) {
		LOG.info("Ingresé al metodo createAnuncio dentro de AnuncioRestController con el parametro "
				+ anuncio.toString());
		return new ResponseEntity<Anuncio>(anuncioService.save(anuncio), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Anuncio> update(@RequestBody Anuncio anuncio) {
		LOG.info("Ingresé al metodo update dentro de AnuncioRestController con el parametro " + anuncio.toString());
		return new ResponseEntity<Anuncio>(anuncioService.save(anuncio), HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		LOG.info("Ingresé al metodo delete dentro de AnuncioRestController con el parametro " + id);

		boolean deleted = anuncioService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("Anuncio with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Anuncio with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}

	}

}
