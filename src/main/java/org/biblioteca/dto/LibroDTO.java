//DTO para la recoleccion de informacion del objeto Libro.
package org.biblioteca.dto;

import org.biblioteca.persistence.entities.LibroEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibroDTO{
	private Integer id;
	private String titulo;
	private String author;
	private Long isbn;

	public static LibroDTO fromEntity(LibroEntity entity){
		return new LibroDTO(entity.getId(),entity.getTitulo(),entity.getAuthor(),entity.getIsbn());
	}

	public LibroEntity toEntity(){
		LibroEntity libroEntity = new LibroEntity();
		libroEntity.setId(this.id);
		libroEntity.setTitulo(this.titulo);
		libroEntity.setAuthor(this.author);
		libroEntity.setIsbn(this.isbn);
		return libroEntity;
	}
}

