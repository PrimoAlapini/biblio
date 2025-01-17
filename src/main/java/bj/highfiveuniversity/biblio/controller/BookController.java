package bj.highfiveuniversity.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.biblio.model.Book;
import bj.highfiveuniversity.biblio.service.BookService;



@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    
    @GetMapping()
    public List<Book> getAllBooks() {
        
        return bookService.getAllBook();
    }

    @PostMapping("add")
    public Book addBook(@RequestBody Book livre) {
        return bookService.addBook(livre);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "le livre avec l'id " + id + " a été supprimé";
    }

    @GetMapping("/{id}")
    public String getBook(@PathVariable Long id) {
        return "le livre avec l'id " + id + " a été trouvé et retourné à la vue \n" + 
        bookService.getBook(id);
    }

    @PutMapping
    public String updateBook(@RequestBody Book livre) {
        bookService.updateBook(livre);
        return "Livre mis à jour";
    }
    
    
}
