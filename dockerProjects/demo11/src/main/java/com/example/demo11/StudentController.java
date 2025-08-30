package com.example.demo11;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepo repository;


    public StudentController(StudentRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    public List<Student> all() {
        return repository.findAll();
    }

    @PostMapping("/students")
    public Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @PutMapping("/students/{id}")
    public Student replaceStudent(@RequestBody Student newStud, @PathVariable Long id) {
        return repository.findById(id)
                .map(stud -> {
                    stud.setName(newStud.getName());
                    stud.setAge(newStud.getAge());
                    return repository.save(stud);
                }).orElseGet(() -> {
                    newStud.setId(id);
                    return repository.save(newStud);
                });
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
