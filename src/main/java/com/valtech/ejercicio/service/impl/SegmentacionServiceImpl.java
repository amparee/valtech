package com.valtech.ejercicio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.repository.SegmentacionJpaRepository;
import com.valtech.ejercicio.service.SegmentacionService;

@Service
public class SegmentacionServiceImpl implements SegmentacionService {

	@Autowired
	private SegmentacionJpaRepository segmentacionJpaRepository;

	private final Log LOG = LogFactory.getLog(SegmentacionServiceImpl.class);

	@Override
	public List<Segmentacion> listSegmentacion() {
		LOG.info("Ingresé al metodo listSegmentación dentro de SegmentacionServiceImpl");
		return segmentacionJpaRepository.findAll();
	}

	@Override
	public Segmentacion findById(Long id) throws NoSuchElementException {
		LOG.info("Ingresé al metodo findById dentro de SegmentacionServiceImpl con el parametro " + id);
		return segmentacionJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Segmentacion doesn't exist with id: " + id));
	}

	@Override
	public Segmentacion save(Segmentacion segmentacion) {
		LOG.info(
				"Ingresé al metodo save dentro de SegmentacionServiceImpl con el parametro " + segmentacion.toString());
		return segmentacionJpaRepository.save(segmentacion);
	}

	@Override
	public boolean delete(Long id) {
		LOG.info("Ingresé al metodo delete dentro de SegmentacionServiceImpl con el parametro " + id);
		Segmentacion segmentacion = segmentacionJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Segmentacion doesn't exist with id: " + id));

		if (segmentacion != null) {
			segmentacionJpaRepository.delete(segmentacion);
			return true;
		} else {
			return false;
		}

	}

}
