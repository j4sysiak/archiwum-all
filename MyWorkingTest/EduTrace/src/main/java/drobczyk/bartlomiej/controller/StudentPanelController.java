package drobczyk.bartlomiej.controller;

import drobczyk.bartlomiej.model.dto.addition_form.LessonFormInfo;
import drobczyk.bartlomiej.model.student.Student;
import drobczyk.bartlomiej.services.StudentService;
import drobczyk.bartlomiej.services.api.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentPanelController {
    private final StudentService studentService;
    private final ApiService apiService;

    @Autowired
    public StudentPanelController(StudentService studentService, ApiService apiService) {
        this.studentService = studentService;
        this.apiService = apiService;
    }

    @GetMapping("/student-panel")
    public String presentPanel(Model model, @RequestParam Long studentId) {
        model.addAttribute("lessonInfo", new LessonFormInfo());
        model.addAttribute("chosenStudent", studentService.provideStudentDto(studentId));
        model.addAttribute("currentLessons", studentService.getCurrentLessonsDto(studentId));
        model.addAttribute("students", studentService.provideStudentsDtosAccordingToTeacher());
        model.addAttribute("weather", apiService.provideWeather(apiService.provideLocationDto()));
        model.addAttribute("quote", apiService.provideRandomQuote());
        return "studentPanel";
    }

    @PostMapping("/add-lesson")
    public String addLessonToStudent(@ModelAttribute LessonFormInfo lessonInfo) {
        Student student = studentService.getStudentById(lessonInfo.getStudentId());
        studentService.saveLessonToStudent(student, lessonInfo);
        return "redirect:/student-panel?studentId=" + lessonInfo.getStudentId();
    }

    @PostMapping("/edit-lesson")
    public String editStudentLesson(@ModelAttribute LessonFormInfo lessonInfo, @RequestParam Long lessonId,
                                    @RequestParam(required = false) boolean isArchiveRequest) {
        Student student = studentService.getStudentById(lessonInfo.getStudentId());
        studentService.editStudentLesson(student, lessonInfo, lessonId);
        if (isArchiveRequest) {
            return "redirect:/archive?studentId=" + lessonInfo.getStudentId();
        }
        return "redirect:/student-panel?studentId=" + lessonInfo.getStudentId();
    }

    @PostMapping("/delete-lesson")
    public String deleteLesson(@RequestParam Long lessonId, @RequestParam Long studentId,
                               @RequestParam(required = false) boolean isArchiveRequest) {
        studentService.deleteStudentsLesson(studentId, lessonId);
        if (isArchiveRequest) {
            return "redirect:/archive?studentId=" + studentId;
        }
        return "redirect:/student-panel?studentId=" + studentId;
    }

    @PostMapping("/archive-lesson")
    public String archiveLessons(@RequestParam Long studentId, @RequestParam Long positionToArchive) {
        studentService.archiveCurrentLessons(studentId, positionToArchive);
        return "redirect:/student-panel?studentId=" + studentId;
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@RequestParam Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/main-panel";
    }
}