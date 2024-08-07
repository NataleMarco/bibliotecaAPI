package org.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.biblioteca.domain.Libro;
import org.biblioteca.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/libros")
public class LibroRestController { 

	@Autowired
	private LibrosService librosService;

	@GetMapping()
	public List<Libro> getLibros() {
		return librosService.getLibros();
	}
	
}
