package org.biblioteca.persistence.repositories;

import org.biblioteca.persistence.entities.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<LibroEntity, Integer>{
}
