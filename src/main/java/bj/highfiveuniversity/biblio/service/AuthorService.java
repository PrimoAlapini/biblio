package bj.highfiveuniversity.biblio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.biblio.model.Author;
import bj.highfiveuniversity.biblio.repository.AuthorRepository;
import jakarta.transaction.Transactional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository auteurRepository;

    public Author addAuthor(Author auteur) {
        return auteurRepository.save(auteur);
    }

    public Optional<Author> getAuthor(Long id) {
        return auteurRepository.findById(id);
    }

    public List<Author> getAllAuthor() {
        // Long count = auteurRepository.count();
        List<Author> auteurs = auteurRepository.findAll();

        return auteurs;
    }

    public void deleteAuthor(Long id) {
        auteurRepository.deleteById(id);
    }

    @Transactional
    public void updateAuthor(Author auteur)
    {
        auteurRepository
        .findById(auteur.getId())
        .ifPresent(newAuteur -> {
            newAuteur.setNom(auteur.getNom());
            newAuteur.setPrenom(auteur.getPrenom());
            newAuteur.setNationnalité(auteur.getNationnalité());

            auteurRepository.save(newAuteur);
        });
    }
}
