package drobczyk.bartlomiej.model.day;

import drobczyk.bartlomiej.model.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "day_id")
    private Long dayId;
    private String day;
    @ManyToMany(mappedBy = "days")
    private List<Student> students = new ArrayList<>();

    public Day() {
    }

    public Day(String day) {
        this.day = day;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}