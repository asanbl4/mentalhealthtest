package com.asanbl4.mentalhealthtest.controllers;

import com.asanbl4.mentalhealthtest.models.Student;
import com.asanbl4.mentalhealthtest.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/")
    public String home(Model model){ return "home"; }
    @PostMapping("/")
    public String homePos(@RequestParam String name, Model model){
        Student student = new Student(name, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, "", "");
        studentRepository.save(student);
        return "redirect:/test/1";
    }

    @GetMapping("/home")
    public String AboutMe(Model model){ return "About me"; }
}
