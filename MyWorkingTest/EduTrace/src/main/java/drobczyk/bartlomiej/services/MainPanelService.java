package drobczyk.bartlomiej.services;

import drobczyk.bartlomiej.model.day.Day;
import drobczyk.bartlomiej.model.dto.addition_form.StudentFormInfo;
import drobczyk.bartlomiej.model.student.Student;
import drobczyk.bartlomiej.model.subject.Subject;
import drobczyk.bartlomiej.model.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MainPanelService {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final SubjectService subjectService;
    private final DayService dayService;


    @Autowired
    public MainPanelService(TeacherService teacherService, StudentService studentService,
                            SubjectService subjectService, DayService dayService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.subjectService = subjectService;
        this.dayService = dayService;
    }

    public void addStudentToTeacher(StudentFormInfo formInfo, Teacher teacher) {
        Student student = createStudentFromForm(formInfo, teacher);
        studentService.saveStudent(student);
        teacher.getStudents().add(student);
        teacherService.saveTeacher(teacher);
    }

    private Student createStudentFromForm(StudentFormInfo formInfo, Teacher teacher) {
        Set<Subject> subjects = formInfo.getSubject().stream()
                .map(this::matchSubjcetWithFormDescription)
                .collect(Collectors.toSet());
        Set<Day> days = formInfo.getDay().stream()
                .map(this::matchDayWithFormDescription)
                .collect(Collectors.toSet());

        return new Student(formInfo.getAvatar(), formInfo.getName(), formInfo.getSurname(), formInfo.getPhone(),
                formInfo.getMail(), formInfo.getGrade(), formInfo.getParent(), formInfo.getParentPhone(), subjects, days,
                formInfo.getExtraInfo(), LocalDateTime.now(), teacher);
    }

    private Subject matchSubjcetWithFormDescription(String subjectDesc) {
        return subjectService.findSubjectByDesc(subjectDesc);
    }

    private Day matchDayWithFormDescription(String dayDesc) {
        return dayService.findDayByDesc(dayDesc);
    }
}