package drobczyk.bartlomiej.controller;

import drobczyk.bartlomiej.model.dto.StudentDto;
import drobczyk.bartlomiej.model.student.Student;
import drobczyk.bartlomiej.services.StudentService;
import drobczyk.bartlomiej.services.api.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArchiveController {
    private final StudentService studentService;
    private final ApiService apiService;

    @Autowired
    public ArchiveController(StudentService studentService, ApiService apiService) {
        this.studentService = studentService;
        this.apiService = apiService;
    }

    @GetMapping("/archive")
    public String findStudentInArchive(@RequestParam(required = false) String student, @RequestParam(required = false) Long studentId, Model model) {
        List<StudentDto> matchedStudents = new ArrayList<>();
        if (student != null) {
            matchedStudents = studentService.findTeachersStudentsInArchive(student);
        }
        model.addAttribute("archivedStudents", matchedStudents);
        model.addAttribute("students", studentService.provideStudentsDtosAccordingToTeacher());
        model.addAttribute("weather", apiService.provideWeather(apiService.provideLocationDto()));
        model.addAttribute("quote", apiService.provideRandomQuote());
        if (studentId != null) {
            Student chosenStudent = studentService.getStudentById(studentId);
            model.addAttribute("chosenStudent", chosenStudent);
            model.addAttribute("currentLessons", studentService.getOrderedLessons(chosenStudent));
            return "studentArchivePanel";
        }
        return "archivePanel";
    }
}
