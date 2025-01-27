package bj.highfiveuniversity.biblio.service.impl;

import bj.highfiveuniversity.biblio.model.Role;
import bj.highfiveuniversity.biblio.repository.RoleRepository;
import bj.highfiveuniversity.biblio.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public Role createRole(Role role) {
        if (roleRepository.existsByName(role.getName())) {
            throw new RuntimeException("Un rôle avec ce nom existe déjà");
        }
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role updateRole(Long id, Role roleDetails) {
        Role existingRole = roleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));

        existingRole.setName(roleDetails.getName());
        existingRole.setDescription(roleDetails.getDescription());

        return roleRepository.save(existingRole);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
        roleRepository.delete(role);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Role> getRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean roleExists(String name) {
        return roleRepository.existsByName(name);
    }
}
