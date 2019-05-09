package com.valtech.ejercicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.valtech.ejercicio.converter.AnuncioConverter;
import com.valtech.ejercicio.entity.Anuncio;
import com.valtech.ejercicio.entity.Segmentacion;
import com.valtech.ejercicio.entity.Usuario;
import com.valtech.ejercicio.model.AnuncioModel;
import com.valtech.ejercicio.service.AnuncioService;

public class AnuncioTests {

	private Anuncio anuncio;
	private AnuncioModel anuncioModel;

	@Mock
	private AnuncioService anuncioService;

	@Before
	public void init() {

		Segmentacion segmentacion = new Segmentacion();
		Usuario usuario = new Usuario();

		anuncio = new Anuncio();
		anuncio.setCostoMaximo(100.00);
		anuncio.setCostoPorImpresion(10.00);
		anuncio.setFechaFin(LocalDate.of(2019, Month.APRIL, 20));
		anuncio.setSegmentacion(segmentacion);
		anuncio.setUsuario(usuario);
		anuncio.setId(1L);

		anuncioModel = AnuncioConverter.convertAnuncioToAnuncioModel(anuncio);

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListAllAnuncios() throws Exception {
		List<Anuncio> list = new ArrayList<Anuncio>();
		Anuncio aOne = new Anuncio();
		Anuncio aTwo = new Anuncio();
		Anuncio aThree = new Anuncio();
		list.add(aOne);
		list.add(aTwo);
		list.add(aThree);
		List<AnuncioModel> listModels = list.parallelStream().map(a -> {
			return AnuncioConverter.convertAnuncioToAnuncioModel(a);
		}).collect(Collectors.toList());
		when(anuncioService.listAnuncios()).thenReturn(listModels);
		List<AnuncioModel> aList = anuncioService.listAnuncios();
		assertEquals(3, aList.size());
		verify(anuncioService, times(1)).listAnuncios();
	}

	@Test
	public void testSaveAnuncio() throws Exception {
		when(anuncioService.save(anuncio)).thenReturn(anuncioModel);
		AnuncioModel aTest = anuncioService.save(anuncio);
		assertNotNull(aTest);
	}

	@Test
	public void testFindAnuncioById() throws Exception {
		when(anuncioService.findById(1L)).thenReturn(anuncioModel);
		AnuncioModel aTest = anuncioService.findById(1L);
		assertNotNull(aTest);
	}

	@Test
	public void testDeleteAnuncio() throws Exception {
		when(anuncioService.delete(1L)).thenReturn(true);
		boolean value = anuncioService.delete(1L);
		assertTrue(value);
	}
}
