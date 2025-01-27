package bj.highfiveuniversity.biblio.service;

import bj.highfiveuniversity.biblio.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    // Créer un nouveau rôle
    Role createRole(Role role);

    // Mettre à jour un rôle existant
    Role updateRole(Long id, Role roleDetails);

    // Supprimer un rôle
    void deleteRole(Long id);

    // Récupérer un rôle par son ID
    Optional<Role> getRoleById(Long id);

    // Récupérer un rôle par son nom
    Optional<Role> getRoleByName(String name);

    // Lister tous les rôles
    List<Role> getAllRoles();

    // Vérifier si un rôle existe
    boolean roleExists(String name);
}
