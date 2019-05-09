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

import com.valtech.ejercicio.entity.Usuario;
import com.valtech.ejercicio.service.UsuarioService;
import com.valtech.ejercicio.service.impl.UsuarioServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioRestController {

	@Autowired
	private UsuarioService usuarioService;

	private final Log LOG = LogFactory.getLog(UsuarioServiceImpl.class);

	@GetMapping("/get-usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios() {
		LOG.info("Ingresé al metodo getUsuarios dentro de UsuarioRestController");
		return new ResponseEntity<List<Usuario>>(usuarioService.listUsuarios(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id) {
		LOG.info("Ingresé al metodo getUsuarioById dentro de UsuarioRestController con el parametro " + id);
		try {
			Usuario usuario = usuarioService.findById(id);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		LOG.info("Ingresé al metodo createUsuario dentro de UsuarioRestController con el parametro "
				+ usuario.toString());
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
		LOG.info("Ingresé al metodo update dentro de UsuarioRestController con el parametro " + usuario.toString());
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {

		LOG.info("Ingresé al metodo delete dentro de UsuarioRestController con el parametro " + id);
		boolean deleted = usuarioService.delete(id);

		if (deleted) {
			return new ResponseEntity<String>("Usuario with id:" + id + " has been deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Usuario with id:" + id + " has not been deleted",
					HttpStatus.METHOD_NOT_ALLOWED);
		}

	}
}
