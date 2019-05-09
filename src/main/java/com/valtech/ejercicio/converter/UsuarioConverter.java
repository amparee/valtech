package com.valtech.ejercicio.converter;

import org.springframework.stereotype.Component;

import com.valtech.ejercicio.entity.Usuario;
import com.valtech.ejercicio.model.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {

	public static UsuarioModel convertUsuarioToUsuarioModel(Usuario usuario) {

		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setAnuncios(usuario.getAnuncios());
		usuarioModel.setEdad(usuario.getEdad());
		usuarioModel.setGenero(usuario.getGenero());
		usuarioModel.setPais(usuario.getPais());
		usuarioModel.setPassword(usuario.getPassword());
		usuarioModel.setUsername(usuario.getUsername());
		return usuarioModel;

	}

	public static Usuario convertUsuarioModelToUsuario(UsuarioModel usuarioModel) {

		Usuario usuario = new Usuario();
		usuario.setAnuncios(usuarioModel.getAnuncios());
		usuario.setEdad(usuarioModel.getEdad());
		usuario.setGenero(usuarioModel.getGenero());
		usuario.setPais(usuarioModel.getPais());
		usuario.setPassword(usuarioModel.getPassword());
		usuario.setUsername(usuarioModel.getUsername());
		return usuario;

	}

}
