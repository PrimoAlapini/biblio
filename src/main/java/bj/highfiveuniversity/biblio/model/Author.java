package bj.highfiveuniversity.biblio.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "auteurs")
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String nationnalité;

    @ManyToMany(mappedBy = "auteurs")
    private Set<Book> books;


    public Author(String nom, String prenom, String nationnalité) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationnalité = nationnalité;
    }

    public long getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNationnalité() {
        return nationnalité;
    }
    public void setNationnalité(String nationnalité) {
        this.nationnalité = nationnalité;
    }
    
}
