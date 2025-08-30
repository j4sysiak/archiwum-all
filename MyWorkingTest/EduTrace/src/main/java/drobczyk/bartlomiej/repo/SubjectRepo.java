package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Optional<Subject> findBySubject(String subjectDesc);
}
