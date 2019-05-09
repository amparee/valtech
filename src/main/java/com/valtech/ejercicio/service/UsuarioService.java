package com.valtech.ejercicio.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.valtech.ejercicio.entity.Usuario;
import com.valtech.ejercicio.model.UsuarioModel;

public interface UsuarioService {
	public abstract List<UsuarioModel> listUsuarios();

	public abstract UsuarioModel findById(Long id) throws NoSuchElementException;

	public abstract UsuarioModel save(Usuario usuario);

	public abstract boolean delete(Long id);
}
