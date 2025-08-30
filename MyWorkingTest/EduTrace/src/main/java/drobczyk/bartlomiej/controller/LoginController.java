package drobczyk.bartlomiej.controller;

import drobczyk.bartlomiej.model.dto.TeacherDto;
import drobczyk.bartlomiej.services.TeacherService;
import drobczyk.bartlomiej.session.TeacherSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
public class LoginController {
    private final TeacherService teacherService;
    private final TeacherSession teacherSession;

    @Autowired
    public LoginController(TeacherService teacherService, TeacherSession teacherSession) {
        this.teacherService = teacherService;
        this.teacherSession = teacherSession;
    }

    @GetMapping("/")
    public String log() {
        return "login";
    }

    @GetMapping("/success")
    public String logIn() {
        return "redirect:/main-panel";
    }

    @GetMapping("/fail")
    public String failLogin(Model model) {
        model.addAttribute("logFail", true);
        model.addAttribute("teacher", new TeacherDto());
        return "login";
    }

    @GetMapping("/loginform")
    public String loginForm(Model model) {
        model.addAttribute("teacher", new TeacherDto());
        return "login";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute TeacherDto dto, BindingResult result, Model model) {
        model.addAttribute("teacher", new TeacherDto());
        if (result.hasErrors()) {
            result.getAllErrors()
                    .forEach(x -> System.err.println(x.getDefaultMessage()));
            model.addAttribute("errors", result.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList()));
            model.addAttribute("registrationFail", true);
            return "login";
        }
        boolean isRegistratrionSuccessful = teacherService.registerTeacher(dto);
        model.addAttribute("registrationOutcome", isRegistratrionSuccessful);
        return "login";
    }

    @GetMapping("/log-out")
    public String logOut() {
        teacherSession.getAuthentication().setAuthenticated(false);
        return "redirect:/loginform";
    }
}