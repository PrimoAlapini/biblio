package bj.highfiveuniversity.biblio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {
    @NotNull(message = "Le nom de l'utilisateur est requis")
    @NotBlank(message = "Le nom d'utilisateur est ne peut être vide")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit être entre 3 et 50 caractères")
    private String username;

    @NotNull(message = "Le mot de passe est requis")
    @NotBlank(message = "Le mot de passe ne peut être vide")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String password;


    // Constructeur avec paramètres
    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

   
    
}
