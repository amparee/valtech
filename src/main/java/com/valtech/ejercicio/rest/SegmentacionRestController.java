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

import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.model.SegmentacionModel;
import com.valtech.ejercicio.service.SegmentacionService;
import com.valtech.ejercicio.service.impl.SegmentacionServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/segmentacion")
public class SegmentacionRestController {

	@Autowired
	private SegmentacionService segmentacionService;

	private final Log LOG = LogFactory.getLog(SegmentacionServiceImpl.class);

	@GetMapping("/get-segmentaciones")
	public ResponseEntity<List<SegmentacionModel>> getSegmentaciones() {
		LOG.info("Ingresé al metodo getSegmentaciones dentro de SegmentacionRestController");
		return new ResponseEntity<List<SegmentacionModel>>(segmentacionService.listSegmentacion(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getSegmentacionById(@PathVariable("id") Long id) {
		LOG.info("Ingresé al metodo getSegmentacionById dentro de SegmentacionRestController con el parametro " + id);
		try {
			SegmentacionModel segmentacionModel = segmentacionService.findById(id);
			return new ResponseEntity<SegmentacionModel>(segmentacionModel, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<SegmentacionModel> createSegmentacion(@RequestBody Segmentacion segmentacion) {
		LOG.info("Ingresé al metodo createSegmentacion dentro de SegmentacionRestController con el parametro "
				+ segmentacion.toString());
		return new ResponseEntity<SegmentacionModel>(segmentacionService.save(segmentacion), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<SegmentacionModel> update(@RequestBody Segmentacion segmentacion) {
		LOG.info("Ingresé al metodo update dentro de SegmentacionRestController con el parametro "
				+ segmentacion.toString());
		return new ResponseEntity<SegmentacionModel>(segmentacionService.save(segmentacion), HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		LOG.info("Ingresé al metodo delete dentro de SegmentacionRestController con el parametro " + id);
		boolean deleted = segmentacionService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("Segmentacion with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Segmentacion with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}

	}
}
