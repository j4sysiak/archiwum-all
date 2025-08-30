package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.roles.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRole(String role);
}
