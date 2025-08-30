package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    boolean existsTeacherByLoginAndEmail(String login, String email);

    Optional<Teacher> findByLogin(String login);
}