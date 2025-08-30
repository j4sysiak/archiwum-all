package com.example.SimpleFormExample.controller;

import com.example.SimpleFormExample.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    //  http://localhost:8080/index
    @GetMapping("/index")
    public String GetForm(Model model) {
        model.addAttribute("Student", new Student());
        return "index";
    }

    //  http://localhost:8080/registration
    @PostMapping("/registration")
    public String PostForm(@ModelAttribute Student student, BindingResult result, Model model)  {
        model.addAttribute("Student", student);
        return "registration";
    }

}
