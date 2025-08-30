package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.lesson.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepo extends JpaRepository<Lesson, Long> {

}
