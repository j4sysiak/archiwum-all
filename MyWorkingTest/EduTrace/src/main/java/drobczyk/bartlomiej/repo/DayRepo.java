package drobczyk.bartlomiej.repo;

import drobczyk.bartlomiej.model.day.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DayRepo extends JpaRepository<Day, Long> {
    Optional<Day> findByDay(String day);
}
