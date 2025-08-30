package drobczyk.bartlomiej.model.dto;

import java.time.LocalDateTime;

public class LessonDto {
    private Long id;
    private String subject;
    private String lessonTopic;
    private String homework;
    private String lessonComment;
    private LocalDateTime lessonDate;

    public LessonDto(Long id, String subject, String lessonTopic,
                     String homework, String lessonComment, LocalDateTime lessonDate) {
        this.id = id;
        this.subject = subject;
        this.lessonTopic = lessonTopic;
        this.homework = homework;
        this.lessonComment = lessonComment;
        this.lessonDate = lessonDate;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getLessonTopic() {
        return lessonTopic;
    }

    public String getHomework() {
        return homework;
    }

    public String getLessonComment() {
        return lessonComment;
    }

    public LocalDateTime getLessonDate() {
        return lessonDate;
    }
}