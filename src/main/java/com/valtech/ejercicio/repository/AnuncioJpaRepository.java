package com.valtech.ejercicio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.ejercicio.entity.Anuncio;

@Repository
public interface AnuncioJpaRepository extends JpaRepository<Anuncio, Long> {

	public List<Anuncio> findAll();

	public Optional<Anuncio> findById(Long id);

	public Anuncio save(Anuncio anuncio);

	public void delete(Anuncio anuncio);
}
