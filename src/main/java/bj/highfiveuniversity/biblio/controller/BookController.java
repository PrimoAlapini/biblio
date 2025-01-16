package bj.highfiveuniversity.biblio.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/book")
public class BookController {
    
    @GetMapping()
    public String getAllBooks() {
        return "Liste de tous les livres";
    }

    @GetMapping("add")
    public String addBook() {
        return "Livre ajouté avec succès";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable String id) {
        return "le livre avec l'id " + id + " a été supprimé";
    }

    @GetMapping("/{id}")
    public String getMethodName(@PathVariable String id) {
        return "le livre avec l'id " + id + " a été trouvé et retourné à la vue";
    }

    @GetMapping("/old/{id}")
    public String getOldBookById(@PathVariable String id) {
        return "Voici les livres les plus vieux: " + id + "";
    }

    @GetMapping("search")
    public String searchBooks(@RequestParam String author, @RequestParam(required = true) String year) {
            return "Recherche des livres de l'auteur : " + author + " pour l'annee : " + year;
    }
    
}
