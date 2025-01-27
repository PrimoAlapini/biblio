package bj.highfiveuniversity.biblio.dto;

import java.util.Set;

import bj.highfiveuniversity.biblio.model.Author;

public class BookDTO {
    
    private Long id;
    private String title;
    private String isbn;
    private Set<Author> auteurs;

    public BookDTO(Long id, String isbn, String title, Set<Author> auteurs) {
        this.auteurs = auteurs;
        this.isbn = isbn;
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Author> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(Set<Author> auteurs) {
        this.auteurs = auteurs;
    }
}
