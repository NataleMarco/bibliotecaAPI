package org.biblioteca.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro{
	private Integer id;
	private String titulo;
	private String author;
	private Integer isbn;
}
