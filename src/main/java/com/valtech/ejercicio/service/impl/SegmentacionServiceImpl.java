package com.valtech.ejercicio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.ejercicio.converter.SegmentacionConverter;
import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.model.SegmentacionModel;
import com.valtech.ejercicio.repository.SegmentacionJpaRepository;
import com.valtech.ejercicio.service.SegmentacionService;

@Service
public class SegmentacionServiceImpl implements SegmentacionService {

	@Autowired
	private SegmentacionJpaRepository segmentacionJpaRepository;

	private final Log LOG = LogFactory.getLog(SegmentacionServiceImpl.class);

	@Override
	public List<SegmentacionModel> listSegmentacion() {
		LOG.info("Ingresé al metodo listSegmentación dentro de SegmentacionServiceImpl");
		return segmentacionJpaRepository.findAll().parallelStream().map(s -> {
			return SegmentacionConverter.convertSegmentacionToSegmentacionModel(s);
		}).collect(Collectors.toList());
	}

	@Override
	public SegmentacionModel findById(Long id) throws NoSuchElementException {
		LOG.info("Ingresé al metodo findById dentro de SegmentacionServiceImpl con el parametro " + id);
		Segmentacion segmentacion = segmentacionJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Segmentacion doesn't exist with id: " + id));
		return SegmentacionConverter.convertSegmentacionToSegmentacionModel(segmentacion);
	}

	@Override
	public SegmentacionModel save(Segmentacion segmentacion) {
		LOG.info(
				"Ingresé al metodo save dentro de SegmentacionServiceImpl con el parametro " + segmentacion.toString());
		Segmentacion segmentacionSaved = segmentacionJpaRepository.save(segmentacion);
		return SegmentacionConverter.convertSegmentacionToSegmentacionModel(segmentacionSaved);
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
