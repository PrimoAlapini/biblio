package bj.highfiveuniversity.biblio.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "livres")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String isbn;

    private LocalDate published_at;

    @ManyToMany
    @JoinTable(
        name = "auteurs_livres",
        joinColumns = @JoinColumn(name = "livres_id"),
        inverseJoinColumns = @JoinColumn(name = "auteurs_id")
    )
    private Set<Author> auteurs;

    public Book( String title, String isbn, LocalDate published_at) {
        this.title = title;
        this.isbn = isbn;
        this.published_at = published_at;
    }

    public long getId() {
        return id;
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

    public LocalDate getPublished_at() {
        return published_at;
    }

    public void setPublished_at(LocalDate published_at) {
        this.published_at = published_at;
    }
}
