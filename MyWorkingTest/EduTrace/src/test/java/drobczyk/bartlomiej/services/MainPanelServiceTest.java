package drobczyk.bartlomiej.services;

import drobczyk.bartlomiej.exceptions.NoSuchDayException;
import drobczyk.bartlomiej.exceptions.NoSuchSubjectException;
import drobczyk.bartlomiej.model.day.Day;
import drobczyk.bartlomiej.model.dto.addition_form.StudentFormInfo;
import drobczyk.bartlomiej.model.student.Student;
import drobczyk.bartlomiej.model.subject.Subject;
import drobczyk.bartlomiej.model.teacher.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MainPanelServiceTest {

    @Mock
    private TeacherService teacherService;
    @Mock
    private StudentService studentService;
    @Mock
    private SubjectService subjectService;
    @Mock
    private DayService dayService;
    private MainPanelService underTest;
    private Teacher testTeacher;
    private Student testStudent;
    private StudentFormInfo studentFormInfo;

    @BeforeEach
    void setUp() {
        underTest = new MainPanelService(teacherService, studentService, subjectService, dayService);
        studentFormInfo = new StudentFormInfo("/img/avatars/maleAvatar1.png", "Adam",
                "Vixij", "564789654", "adam@op.pl", "Wojtek", "8456987456",
                "test", 7, List.of("Fizyka"), List.of("Wtorek"));
        testTeacher = new Teacher();
        testStudent = new Student(studentFormInfo.getAvatar(), studentFormInfo.getName(), studentFormInfo.getSurname(),
                studentFormInfo.getPhone(), studentFormInfo.getMail(), studentFormInfo.getGrade(), studentFormInfo.getParent(),
                studentFormInfo.getParentPhone(),
                studentFormInfo.getSubject().stream()
                        .map(Subject::new)
                        .collect(Collectors.toSet()),
                studentFormInfo.getDay().stream()
                        .map(Day::new)
                        .collect(Collectors.toSet()), studentFormInfo.getExtraInfo(),
                LocalDateTime.now(), testTeacher);
    }

    @Test
    void shouldAddStudentToTeacher() {
        //when
        given(dayService.findDayByDesc("Wtorek")).willReturn(new Day("Wtorek"));
        given(subjectService.findSubjectByDesc("Fizyka")).willReturn(new Subject("Fizyka"));
        underTest.addStudentToTeacher(studentFormInfo, testTeacher);
        //then
        var studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        var teacherArgumentCaptor = ArgumentCaptor.forClass(Teacher.class);
        verify(studentService).saveStudent(studentArgumentCaptor.capture());
        verify(teacherService).saveTeacher(teacherArgumentCaptor.capture());
        assertThat(studentArgumentCaptor.getValue()).isEqualTo(testStudent);
        assertThat(teacherArgumentCaptor.getValue()).isEqualTo(testTeacher);
    }

    @Test
    void shouldThrowNoSuchDayException() {
        //given
        studentFormInfo.setDay(Collections.singletonList("Wtoooorek"));
        //when
        given(dayService.findDayByDesc(studentFormInfo.getDay().get(0)))
                .willThrow(new NoSuchDayException());
        assertThatThrownBy(() -> underTest.addStudentToTeacher(studentFormInfo, testTeacher))
                .isInstanceOf(NoSuchDayException.class)
                .hasMessageContaining("Brak wskazanego dnia");
        verify(studentService, never()).saveStudent(any());
        verify(teacherService, never()).saveTeacher(any());
    }

    @Test
    void shouldThrowNoSuchSubjectException() {
        //given
        studentFormInfo.setSubject(Collections.singletonList("Fiiizyka"));
        //when
        given(subjectService.findSubjectByDesc(studentFormInfo.getSubject().get(0)))
                .willThrow(new NoSuchSubjectException());
        assertThatThrownBy(() -> underTest.addStudentToTeacher(studentFormInfo, testTeacher))
                .isInstanceOf(NoSuchSubjectException.class)
                .hasMessageContaining("Brak wskazanego przedmiotu");
        verify(studentService, never()).saveStudent(any());
        verify(teacherService, never()).saveTeacher(any());
    }
}