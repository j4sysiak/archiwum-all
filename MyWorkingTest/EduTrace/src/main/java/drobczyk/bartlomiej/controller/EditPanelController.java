package drobczyk.bartlomiej.controller;

import drobczyk.bartlomiej.model.dto.edit_form.BasicInfoEdit;
import drobczyk.bartlomiej.model.dto.edit_form.SubjectInfoEdit;
import drobczyk.bartlomiej.services.StudentService;
import drobczyk.bartlomiej.services.api.ApiService;
import drobczyk.bartlomiej.session.TeacherSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class EditPanelController {
    private final StudentService studentService;
    private final TeacherSession teacherSession;
    private final ApiService apiService;

    @Autowired
    public EditPanelController(StudentService studentService, TeacherSession teacherSession, ApiService apiService) {
        this.studentService = studentService;
        this.teacherSession = teacherSession;
        this.apiService = apiService;
    }

    @GetMapping("/edit-student")
    public String presentEditPanel(@RequestParam Long studentId, Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        model.addAttribute("basicInfo", new BasicInfoEdit());
        model.addAttribute("subjectInfo", new SubjectInfoEdit());
        model.addAttribute("chosenStudent", studentService.provideStudentDto(studentId));
        model.addAttribute("students", studentService.provideStudentsDtosAccordingToTeacher());
        model.addAttribute("weather", apiService.provideWeather(apiService.provideLocationDto()));
        model.addAttribute("quote", apiService.provideRandomQuote());
        if (inputFlashMap != null) {
            BindingResult result = (BindingResult) inputFlashMap.get("errors");
            List<String> errorsList = result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .distinct()
                    .collect(Collectors.toList());
            model.addAttribute("errors", errorsList);
            model.addAttribute("editionFailed", true);
        }
        return "editProfilePanel";
    }

    @PostMapping("/edit-student/avatar")
    public String changeAvatar(@RequestParam String avatar, @RequestParam Long studentId) {
        studentService.changeStudentAvatar(avatar, studentId);
        return "redirect:/edit-student?studentId=" + studentId;
    }

    @PostMapping("/edit-student/basic-info")
    public String editBasicInfo(@Valid @ModelAttribute BasicInfoEdit basicInfo, BindingResult result,
                                @RequestParam Long studentId,
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return getErrors(studentId, result, redirectAttributes);
        }
        studentService.editBasicInfo(basicInfo, studentId);
        return "redirect:/edit-student?studentId=" + studentId;
    }

    @PostMapping("/edit-student/subject-info")
    public String editSubjectInfo(@Valid @ModelAttribute SubjectInfoEdit subjectInfoEdit, BindingResult result,
                                  @RequestParam Long studentId, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return getErrors(studentId, result, redirectAttributes);
        }
        studentService.editSubjectInfo(subjectInfoEdit, studentId);
        return "redirect:/edit-student?studentId=" + studentId;
    }

    private String getErrors(Long studentId, BindingResult result, RedirectAttributes redirectAttributes) {
        result.getAllErrors()
                .forEach(x -> System.err.println(x.getDefaultMessage()));
        redirectAttributes.addFlashAttribute("errors", result);
        return "redirect:/edit-student?studentId=" + studentId;
    }
}