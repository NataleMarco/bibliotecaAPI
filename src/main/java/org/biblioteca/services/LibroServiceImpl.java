//LibroServiceImpl.java
package org.biblioteca.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.biblioteca.dto.LibroDTO;
import org.biblioteca.dto.SaveLibroDTO;
import org.biblioteca.dto.SaveLibroResponseDTO;
import org.biblioteca.exceptions.ResourceNotFoundException;
import org.biblioteca.persistence.entities.LibroEntity;
import org.biblioteca.persistence.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Data
public class LibroServiceImpl implements LibrosService{

	@Autowired
	private LibrosRepository librosRepository;

	//Obtener la lista en DTO de todos los libros de la base de datos
	@Override
	public List<LibroDTO> getLibros(){
		List<LibroEntity> libroEntities = librosRepository.findAll();
		List<LibroDTO>libros = new ArrayList<LibroDTO>();
		for(LibroEntity libroEntity: libroEntities){
			libros.add(LibroDTO.fromEntity(libroEntity));
		}
		return libros;
	}

	//Guardar un libro nuevo ingresado por el usuario
	@Override
	public SaveLibroResponseDTO saveLibro(SaveLibroDTO saveDTO){
		LibroEntity libroEntity = LibroEntity.fromSaveDTO(saveDTO);
		libroEntity = librosRepository.save(libroEntity);
		LibroDTO libroDTO = LibroDTO.fromEntity(libroEntity);
		URI location =  ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(libroDTO.getId())
		.toUri();

		SaveLibroResponseDTO responseDTO = new SaveLibroResponseDTO(location,libroDTO);
		return responseDTO;
	}

	//Buscar el libro por ID y eliminar su entidad.
	@Override
	public LibroDTO removeLibroById(Integer id){
		LibroEntity libro = getLibroEntityById(id);
		LibroDTO libroDTO = LibroDTO.fromEntity(libro);
		librosRepository.delete(libro);
		return libroDTO;
	}

	//Buscar el libro por id y devolver el DTO
	@Override
	public LibroDTO getLibroById(Integer id){
		return LibroDTO.fromEntity(getLibroEntityById(id));
	}

	//Actualizar la informacion de un libro
	@Override
	public LibroDTO updateLibro(Integer id, SaveLibroDTO libro){
		LibroEntity libroEntity = getLibroEntityById(id);
		libroEntity = LibroEntity.fromSaveDTO(libro);
		libroEntity.setId(id);
		librosRepository.save(libroEntity);

		return LibroDTO.fromEntity(libroEntity);
	}

	//Buscar el libro por autor y devolver el/los DTO
	@Override
	public List<LibroDTO> getLibrosByAuthor(String author){

		List<LibroDTO> librosDTOs = new ArrayList<>();
		List<LibroEntity> librosEntities = getLibrosEntitiesByAuthor(author);

		for(LibroEntity libro:librosEntities){
			librosDTOs.add(LibroDTO.fromEntity(libro));
		}

		return librosDTOs;
	}

	//Buscar el libro por ISBN y devolver el DTO
	@Override
	public LibroDTO getLibroByIsbn(Long isbn){
		return LibroDTO.fromEntity(getLibroEntityByIsbn(isbn));

	}

	//Buscar el libro por el titulo y devolver el DTO
	@Override
	public List<LibroDTO> getLibrosByTitulo(String titulo){
		List<LibroDTO> librosDTOs = new ArrayList<>();
		List<LibroEntity> librosEntities = getLibroEntityByTitulo(titulo);

		for(LibroEntity libro:librosEntities){
			librosDTOs.add(LibroDTO.fromEntity(libro));
		}

		return librosDTOs;
	}


	//										UTILS
	//----------------------------------------------------------------------------------
	//
	//Buscadores de entities para usar en el mismo service, no se debe utilizar esto en el controller
	// POR ID 
	private LibroEntity getLibroEntityById(Integer id){
		log.info("librosService - getLibroEntityById");
		List<LibroEntity> libros = librosRepository.findAll();
		return libros.stream()
		.filter(libro -> libro.getId() .equals(id))
		.findAny()
		.orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun libro con el id " + id));
	}

	// POR AUTOR 
	private List<LibroEntity> getLibrosEntitiesByAuthor(String author){
		List<LibroEntity> libros = librosRepository.findAll();
		List<LibroEntity> librosEncontrados =
		libros.stream()
		.filter(libro -> libro.getAuthor().toLowerCase().contains(author.toLowerCase()))
		.collect(Collectors.toList());
		if (librosEncontrados.isEmpty()){
			throw new ResourceNotFoundException("No se encontro ningun libro con el autor " + author);
		}else{
			return librosEncontrados;
		}
	}

	// POR ISBN 
	private LibroEntity getLibroEntityByIsbn(Long isbn){
		List<LibroEntity> libros = librosRepository.findAll();
		return libros.stream()
		.filter(libro -> libro.getIsbn().equals(isbn))
		.findAny()
		.orElseThrow(() -> new ResourceNotFoundException("No se encontro ningun libro con el isbn " + isbn));

	}

	// POR TITULO 
	private List<LibroEntity> getLibroEntityByTitulo(String titulo){
		List<LibroEntity> libros = librosRepository.findAll();
		List<LibroEntity> librosEncontrados = 
		libros.stream()
		.filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
		.collect(Collectors.toList());
		if (librosEncontrados.isEmpty()){
			throw new ResourceNotFoundException("No se encontro ningun libro con el titulo " + titulo);
		}else{
			return librosEncontrados;
		}
	}

}
