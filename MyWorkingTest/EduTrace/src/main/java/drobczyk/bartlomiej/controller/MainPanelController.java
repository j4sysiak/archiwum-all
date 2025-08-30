package drobczyk.bartlomiej.controller;

import drobczyk.bartlomiej.model.dto.addition_form.StudentFormInfo;
import drobczyk.bartlomiej.services.MainPanelService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MainPanelController {
    private final MainPanelService mainPanelService;
    private final StudentService studentService;
    private final ApiService apiService;
    private final TeacherSession teacherSession;

    @Autowired
    public MainPanelController(MainPanelService panelService, StudentService studentService,
                               ApiService apiService, TeacherSession teacherSession) {
        this.mainPanelService = panelService;
        this.studentService = studentService;
        this.apiService = apiService;
        this.teacherSession = teacherSession;
    }


    @GetMapping("/main-panel")
    public String presentPanel(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        model.addAttribute("studentBasicInfo", new StudentFormInfo());
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
            model.addAttribute("additionFailed", true);
        }
        if (teacherSession.getLoggedTeacher()
                .getStudents()
                .isEmpty()) {
            return "firstContactPanel";
        }
        return "mainPanel";
    }

    @PostMapping("/add-student")
    public String addStudentToTeacher(@Valid @ModelAttribute StudentFormInfo studentBasicInfo, BindingResult result,
                                      RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            result.getAllErrors()
                    .forEach(x -> System.err.println(x.getDefaultMessage()));
            redirectAttributes.addFlashAttribute("errors", result);
            return "redirect:/main-panel";
        }
        mainPanelService.addStudentToTeacher(studentBasicInfo, teacherSession.getLoggedTeacher());
        return "redirect:/main-panel";
    }
}