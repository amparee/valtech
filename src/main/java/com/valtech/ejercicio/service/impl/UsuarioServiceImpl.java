package com.valtech.ejercicio.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.ejercicio.entity.Usuario;
import com.valtech.ejercicio.repository.UsuarioJpaRepository;
import com.valtech.ejercicio.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioJpaRepository usuarioJpaRepository;

	private final Log LOG = LogFactory.getLog(UsuarioServiceImpl.class);

	@Override
	public List<Usuario> listUsuarios() {
		LOG.info("Ingresé al metodo listUsuarios dentro de UsuarioServiceImpl");
		return usuarioJpaRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) throws NoSuchElementException {
		LOG.info("Ingresé al metodo findById dentro de UsuarioServiceImpl");
		return usuarioJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Usuario doesn't exist with id: " + id));
	}

	@Override
	public Usuario save(Usuario usuario) {
		LOG.info("Ingresé al metodo save dentro de UsuarioServiceImpl");
		return usuarioJpaRepository.save(usuario);
	}

	@Override
	public boolean delete(Long id) {
		LOG.info("Ingresé al metodo delete dentro de UsuarioServiceImpl");
		Usuario usuario = usuarioJpaRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Usuario doesn't exist with id: " + id));

		if (usuario != null) {
			usuarioJpaRepository.delete(usuario);
			return true;
		} else {
			return false;
		}

	}

}
