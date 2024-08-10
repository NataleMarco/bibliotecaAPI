//DTO para la respuesta del metodo SaveLibro.

package org.biblioteca.dto;

import java.net.URI;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SaveLibroResponseDTO{
	private URI uri;
	private LibroDTO libro;
}
