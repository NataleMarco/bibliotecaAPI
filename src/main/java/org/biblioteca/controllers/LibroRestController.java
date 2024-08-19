//LibroRestController.java
package org.biblioteca.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

import org.biblioteca.dto.SaveLibroDTO;
import org.biblioteca.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Log4j2
@RestController
@RequestMapping("/libros")
public class LibroRestController {

		@Autowired
		private LibrosService librosService;

		@GetMapping()
		public ResponseEntity<?> getLibros() {
				return ResponseEntity.ok().body(librosService.getLibros());
		}

		@GetMapping("/search/author/{author}")
		public ResponseEntity<?> getLibrosByAuthor(@PathVariable String author){
				return ResponseEntity.ok().body(librosService.getLibrosByAuthor(author));
		}

		@GetMapping("/search/titulo/{titulo}")
		public ResponseEntity<?> getLibrosByTitulo(@PathVariable String titulo){
				return ResponseEntity.ok().body(librosService.getLibrosByTitulo(titulo));
		}

		@GetMapping("/search/isbn/{isbn}")
		public ResponseEntity<?> getLibrosByIsbn(@PathVariable Long isbn){
				return ResponseEntity.ok().body(librosService.getLibroByIsbn(isbn));
		}
		

		@PutMapping("/{id}")
		public ResponseEntity<?> updateLibro(@PathVariable Integer id,@RequestBody SaveLibroDTO libro){

				return ResponseEntity.ok().body(librosService.updateLibro(id,libro));

		}
		@PostMapping()
		public ResponseEntity<?> postLibro(@RequestBody SaveLibroDTO saveLibroDTO) {
				return ResponseEntity.ok().body(librosService.saveLibro(saveLibroDTO));
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteLibro(@PathVariable Integer id){
				return ResponseEntity.ok().body(librosService.removeLibroById(id));
		}

		@GetMapping("/{id}")
		public ResponseEntity<?> getLibroById(@PathVariable Integer id){
				log.info("LibroRestController - getLibroById");
				return ResponseEntity.ok().body(librosService.getLibroById(id));
		}
}
