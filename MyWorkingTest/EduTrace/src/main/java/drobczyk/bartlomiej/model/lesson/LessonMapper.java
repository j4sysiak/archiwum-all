package drobczyk.bartlomiej.model.lesson;

import drobczyk.bartlomiej.model.dto.LessonDto;

public class LessonMapper {
    public static LessonDto toDto(Lesson lesson) {
        return new LessonDto(lesson.getId(), lesson.getSubject().getSubject(), lesson.getLessonTopic(),
                lesson.getHomework(), lesson.getLessonComment(), lesson.getLessonDate());
    }
}