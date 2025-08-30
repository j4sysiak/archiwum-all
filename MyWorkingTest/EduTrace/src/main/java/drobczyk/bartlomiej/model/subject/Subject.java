package drobczyk.bartlomiej.model.subject;

import drobczyk.bartlomiej.model.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subject_id;
    private String subject;
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();

    public Subject() {
    }

    public Subject(String subject) {
        this.subject = subject;
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return subject;
    }
}