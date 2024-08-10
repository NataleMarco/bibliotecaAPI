package org.biblioteca.persistence.entities;

import org.biblioteca.dto.LibroDTO;
import org.biblioteca.dto.SaveLibroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "libros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroEntity{ 

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String titulo;
	private String author;
	private Long isbn;
	

	public static LibroEntity fromSaveDTO(SaveLibroDTO saveDTO) { 
		LibroEntity libroEntity = new LibroEntity();
		libroEntity.setAuthor(saveDTO.getAuthor());
		libroEntity.setIsbn(saveDTO.getIsbn());
		libroEntity.setTitulo(saveDTO.getTitulo());
		return libroEntity;
	}
		public static LibroEntity fromLibroDTO(LibroDTO libroDTO){
				return new LibroEntity(libroDTO.getId(), libroDTO.getTitulo(),libroDTO.getAuthor(),libroDTO.getIsbn());
		}

}
