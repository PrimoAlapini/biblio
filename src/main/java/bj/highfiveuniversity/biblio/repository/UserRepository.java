package bj.highfiveuniversity.biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bj.highfiveuniversity.biblio.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
