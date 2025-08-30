package drobczyk.bartlomiej.model.dto.addition_form;

import org.springframework.stereotype.Component;

@Component
public class LessonFormInfo {
    private String chosenLesson;
    private String lessonSection;
    private String homework;
    private String lessonComment;
    private Long studentId;

    public String getChosenLesson() {
        return chosenLesson;
    }

    public void setChosenLesson(String chosenLesson) {
        this.chosenLesson = chosenLesson;
    }

    public String getLessonSection() {
        return lessonSection;
    }

    public void setLessonSection(String lessonSection) {
        this.lessonSection = lessonSection;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}