package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.entities.Student;
import ru.geekbrains.repositories.StudentRepository;
import ru.geekbrains.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/{id}")
    public String editStudent(@PathVariable(value = "id") Long id,
                              Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "student_form";
    }

    @PostMapping("/student_update")
    public String updateProduct(Student student) {
        if (student.getStudent_id() == null) {
            studentService.add(student);
        } else {
            studentService.update(student);
        }
        return "redirect:/student";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute(new Student());
        return "student_form";
    }

    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable(value = "id") Long id) {
        studentService.remove(id);
        return "redirect:/student";
    }
}
