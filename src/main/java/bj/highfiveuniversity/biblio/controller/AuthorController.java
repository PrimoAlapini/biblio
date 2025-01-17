package bj.highfiveuniversity.biblio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bj.highfiveuniversity.biblio.model.Author;
import bj.highfiveuniversity.biblio.service.AuthorService;


@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService auteurService;
    
    @PostMapping("add")
    public Author addAuthor(@Validated @RequestBody Author auteur) {

        return auteurService.addAuthor(auteur);
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthor(@PathVariable Long id) {
        return auteurService.getAuthor(id);
    }

    @GetMapping("all/aut")
    public List<Author> getAll() {
        return auteurService.getAllAuthor();
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        auteurService.deleteAuthor(id);
        return "Auteur supprimé avec succès";
    }

    @PutMapping("update")
    public void updateAuthor(@RequestBody Author auteur){
        auteurService.updateAuthor(auteur);
    }

}
