package drobczyk.bartlomiej.model.student;

import drobczyk.bartlomiej.model.day.Day;
import drobczyk.bartlomiej.model.dto.StudentDto;
import drobczyk.bartlomiej.model.subject.Subject;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {
    public static StudentDto toDto(Student student) {
        List<String> subjects = student.getSubjects().stream()
                .map(Subject::getSubject)
                .collect(Collectors.toList());
        List<String> days = student.getDays().stream()
                .map(Day::getDay)
                .collect(Collectors.toList());
        int totalLessonAmount = student.getLessons().size();
        return new StudentDto(student.getId(), student.getName(), student.getSurname(), student.getPhone(),
                student.getEmail(), student.getGrade(), student.getParent(), student.getParentNumber(),
                student.getAdditionalInfo(), student.getAvatarUrl(), totalLessonAmount, student.getLastArchivedPosition(), subjects, days);
    }
}