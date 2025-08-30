package com.example.demo.student;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentService.class})
@ExtendWith(SpringExtension.class)
class StudentServiceDiffblueTest {
    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * Method under test: {@link StudentService#deleteStudent(Long)}
     */
    @Test
    void testDeleteStudent() {
        doNothing().when(studentRepository).deleteById(Mockito.<Long>any());
        when(studentRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        studentService.deleteStudent(1L);
        verify(studentRepository).deleteById(Mockito.<Long>any());
        verify(studentRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StudentService#deleteStudent(Long)}
     */
    @Test
    void testDeleteStudent2() {
        doThrow(new BadRequestException("Msg")).when(studentRepository).deleteById(Mockito.<Long>any());
        when(studentRepository.existsById(Mockito.<Long>any())).thenReturn(true);
        assertThrows(BadRequestException.class, () -> studentService.deleteStudent(1L));
        verify(studentRepository).deleteById(Mockito.<Long>any());
        verify(studentRepository).existsById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link StudentService#deleteStudent(Long)}
     */
    @Test
    void testDeleteStudent3() {
        when(studentRepository.existsById(Mockito.<Long>any())).thenReturn(false);
        assertThrows(StudentNotFoundException.class, () -> studentService.deleteStudent(1L));
        verify(studentRepository).existsById(Mockito.<Long>any());
    }
}
