package drobczyk.bartlomiej.model.lesson;

import drobczyk.bartlomiej.model.student.Student;
import drobczyk.bartlomiej.model.subject.Subject;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table()
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id")
    private Long id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Subject subject;
    private String lessonTopic;
    private String homework;
    private String lessonComment;
    private LocalDateTime lessonDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Student student;


    public Lesson() {
    }

    public Lesson(Subject subject, String lessonTopic, String homework,
                  String lessonComment, LocalDateTime lessonDate, Student student) {
        this.subject = subject;
        this.lessonTopic = lessonTopic;
        this.homework = homework;
        this.lessonComment = lessonComment;
        this.lessonDate = lessonDate;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getLessonTopic() {
        return lessonTopic;
    }

    public void setLessonTopic(String lessonTopic) {
        this.lessonTopic = lessonTopic;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getLessonComment() {
        return lessonComment;
    }

    public void setLessonComment(String lessonComment) {
        this.lessonComment = lessonComment;
    }

    public LocalDateTime getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(LocalDateTime lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}