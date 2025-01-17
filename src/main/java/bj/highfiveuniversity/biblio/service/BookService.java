package bj.highfiveuniversity.biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.biblio.model.Book;
import bj.highfiveuniversity.biblio.repository.BookRepository;
import jakarta.transaction.Transactional;


@Service
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book livre) {
        return bookRepository.save(livre);
    }

    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(Book livre) {
        bookRepository.findById(livre.getId())
        .ifPresent(el -> {
            el.setTitle(livre.getTitle());
            el.setIsbn(livre.getIsbn());
            el.setPublished_at(livre.getPublished_at());

           bookRepository.save(el);
        });
    }
}
