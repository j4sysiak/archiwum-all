package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Override
    Optional<Student> findById(Long aLong);

    @Query("SELECT s FROM Student s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%',:text,'%'))" +
            " OR LOWER(s.surname) LIKE LOWER(CONCAT('%',:text,'%'))")
    List<Student> findMatchedStudentsByString(@Param("text") String text);

}