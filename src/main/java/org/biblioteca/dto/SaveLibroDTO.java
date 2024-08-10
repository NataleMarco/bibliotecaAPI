//DTO para los parametros del metodo saveLibro.
package org.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveLibroDTO{
	private String titulo;
	private String author;
	private Long isbn;
}
