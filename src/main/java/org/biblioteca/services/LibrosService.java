package org.biblioteca.services;


import java.util.List;

import org.biblioteca.domain.Libro;

public interface LibrosService{
	public void addLibro();
	public void removeLibro();
	public void updateLibro();
	public List<Libro> getLibros();
	public Libro getLibroById();
	public List<Libro> getLibrosByAuthor();
	public Libro getLibroByIsbn();
	public List<Libro> getLibroByName();
}
