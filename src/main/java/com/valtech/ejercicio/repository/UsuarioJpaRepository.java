package com.valtech.ejercicio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.ejercicio.entity.Usuario;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findAll();

	public Optional<Usuario> findById(Long id);

	public Usuario save(Usuario usuario);

	public void delete(Usuario usuario);
}
