package com.example.demo.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest2 {

    @Mock
    private StudentRepository studentRepository;
    //private AutoCloseable autoCloseable;
    private StudentService underTest;


    @BeforeEach
    void setUp() {
        //autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

    /*
        @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }
    */


    @Test
    void canGetAllStudents() {
        //when
        underTest.getAllStudents();

        //then
        verify(studentRepository).findAll();
    }
}







































