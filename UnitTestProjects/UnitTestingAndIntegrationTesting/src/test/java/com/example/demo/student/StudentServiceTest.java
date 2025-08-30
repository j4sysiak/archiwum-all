package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private AutoCloseable autoCloseable;

    private StudentService underTest;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStudents() {
        //when
        underTest.getAllStudents();

        //then
        verify(studentRepository).findAll();


    }

    @Test
    void canAddStudent() {

        //https://www.youtube.com/watch?v=Geq60OVyBPg   54' 23''

        //given
        String mail = "jacek@wp.pl";
        Student student = new Student(
                "Jacek",
                mail,
                Gender.FEMALE
        );

        //when
        underTest.addStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();

        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowExceptionWhenGivenEmailWasAllreadyTaken() {

        //https://www.youtube.com/watch?v=Geq60OVyBPg   1h 03' 00''

        //given
        String mail = "jacek@wp.pl";
        Student student = new Student(
                "Jacek",
                mail,
                Gender.FEMALE
        );

        given(studentRepository.selectExistsEmail(anyString()))
                .willReturn(true);

        //when & then
        assertThatThrownBy( () -> underTest.addStudent(student) )
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository, never()).save(any());
    }

    @Test
    @Disabled
    void deleteStudent() {
    }
}







































