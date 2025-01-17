package bj.highfiveuniversity.biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.biblio.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
