//LibroService.java
package org.biblioteca.services;


import java.util.List;

import org.biblioteca.dto.LibroDTO;
import org.biblioteca.dto.SaveLibroDTO;
import org.biblioteca.dto.SaveLibroResponseDTO;

public interface LibrosService{
	List<LibroDTO> getLibros();
	List<LibroDTO> getLibrosByAuthor(String author);
	List<LibroDTO> getLibroByTitulo(String name);
	LibroDTO getLibroById(Integer id);
	LibroDTO getLibroByIsbn(Long isbn);
	SaveLibroResponseDTO saveLibro(SaveLibroDTO libro);
	LibroDTO removeLibroById(Integer id);
	void updateLibro();

	
}
