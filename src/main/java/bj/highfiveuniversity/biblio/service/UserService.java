package bj.highfiveuniversity.biblio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bj.highfiveuniversity.biblio.dto.RegisterDTO;
import bj.highfiveuniversity.biblio.model.Role;
import bj.highfiveuniversity.biblio.model.User;
import bj.highfiveuniversity.biblio.repository.RoleRepository;
import bj.highfiveuniversity.biblio.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    public void register(RegisterDTO registerData) {
        User newUser = new User();
        newUser.setUsername(registerData.getUsername());
        newUser.setEmail(registerData.getEmail());
        newUser.setDob(registerData.getDob());
        newUser.setPassword(registerData.getPassword());

        // Récupérer les rôles et les associer à l'utilisateur
        List<Role> userRoles = new ArrayList<>();

        // Vérification si la liste des rôles est nulle ou vide
        if (registerData.getRoles() == null || registerData.getRoles().isEmpty()) {
            // Attribution du rôle par défaut
            Role defaultRole = roleRepository.findByName("USER")
                    .orElseThrow(() -> new RuntimeException("Rôle par défaut 'USER' non trouvé"));
            userRoles.add(defaultRole);
        } else {
            // Traitement des rôles fournis
            for (String roleName : registerData.getRoles()) {
                Role userRole = roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Rôle non trouvé : " + roleName));
                userRoles.add(userRole);
            }
        }

        newUser.setRoles(userRoles);  // Attribution du ou des rôles à l'utilisateur
        userRepository.save(newUser);
    }
}
