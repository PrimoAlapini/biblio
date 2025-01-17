package bj.highfiveuniversity.biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.biblio.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
