package com.valtech.ejercicio.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.valtech.ejercicio.entity.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> listUsuarios();

	public abstract Usuario findById(Long id) throws NoSuchElementException;

	public abstract Usuario save(Usuario usuario);

	public abstract boolean delete(Long id);
}
