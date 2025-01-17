package bj.highfiveuniversity.biblio.mapper;

import bj.highfiveuniversity.biblio.dto.AuthorDTO;
import bj.highfiveuniversity.biblio.model.Author;

public class AuthorMapper {
    
    public static AuthorDTO toDTO(Author auteur) {
        return new AuthorDTO(auteur.getId(), auteur.getNom(), auteur.getPrenom());
    } 
}
