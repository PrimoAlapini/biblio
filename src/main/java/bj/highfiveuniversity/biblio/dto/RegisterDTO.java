package bj.highfiveuniversity.biblio.dto;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Data
public class RegisterDTO {

    @NotNull(message = "Le nom de l'utilisateur est requis")
    @NotBlank(message = "Le nom d'utilisateur est ne peut être vide")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit être entre 3 et 50 caractères")
    private String username;
    
    @NotNull(message = "Le mot de passe est requis")
    @NotBlank(message = "Le mot de passe ne peut être vide")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    @Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", 
        message = "Le mot de passe doit contenir au moins une lettre, un chiffre et un symbole spécial"
    )
    private String password;
    
    @NotNull(message = "La date de naissance est requis")
    @NotBlank(message = "La date de naissance ne peut être vide")
    private String dob;
    
    @NotNull(message = "L'email est requis")
    @NotBlank(message = "L'email ne peut être vide")
    @Email(message = "Le format de l'email est incorrect")
    private String email;

    private List<String> roles;

    // Constructeur avec paramètres
    public RegisterDTO(String username, String password,  List<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
}

