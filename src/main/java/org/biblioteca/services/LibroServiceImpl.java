package org.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.biblioteca.domain.Libro;
import org.biblioteca.persistence.entities.LibroEntity;
import org.biblioteca.persistence.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class LibroServiceImpl implements LibrosService{

	@Autowired
	private LibrosRepository librosRepository;

	@Override
	public void addLibro(){
	}
	@Override
	public void removeLibro(){

	}
	@Override
	public void updateLibro(){

	}
	@Override
	public List<Libro> getLibros(){
		List<LibroEntity> libroEntities = librosRepository.findAll();
		List<Libro> libros = new ArrayList<Libro>();
		for(LibroEntity libroEntity: libroEntities){
			Libro libro = new Libro();
			libro.setId(libroEntity.getId());
			libro.setAuthor(libroEntity.getAuthor());
			libro.setTitulo(libroEntity.getTitulo());
			libro.setIsbn(libroEntity.getIsbn());
			libros.add(libro);
		}
		return libros;
	}
	@Override
	public Libro getLibroById(){
		return null;
	}
	@Override
	public List<Libro> getLibrosByAuthor(){
		return null;
	}
	@Override
	public Libro getLibroByIsbn(){
		return null;
	}
	@Override
	public List<Libro> getLibroByName(){
		return null;
	}
}
