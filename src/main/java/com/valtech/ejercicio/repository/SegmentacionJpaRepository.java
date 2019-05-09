package com.valtech.ejercicio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.ejercicio.entity.Segmentacion;

@Repository
public interface SegmentacionJpaRepository extends JpaRepository<Segmentacion, Long> {

	public List<Segmentacion> findAll();

	public Optional<Segmentacion> findById(Long id);

	public Segmentacion save(Segmentacion segmentacion);

	public void delete(Segmentacion segmentacion);

}
