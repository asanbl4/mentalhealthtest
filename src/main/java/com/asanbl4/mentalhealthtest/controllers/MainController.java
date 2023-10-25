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
        Student student = new Student(name, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        studentRepository.save(student);
        return "redirect:/test/1";
    }

    @GetMapping("/results")
    public String results(Model model){
        Iterable<Student> students = studentRepository.findAll();
        Student last_student = null;
        for(Student student: students){ last_student = student; }
        assert last_student != null;
        model.addAttribute("name", last_student.getName());
        int sum = last_student.getQ1() + last_student.getQ2() + last_student.getQ3() + last_student.getQ4() + last_student.getQ5() + last_student.getQ6() + last_student.getQ7() + last_student.getQ8() + last_student.getQ9() + last_student.getQ10();
        String res = "";
        if (sum < 20){res = "Your psycho-test results are OK, you do not need any mental health help";}
        else if (sum >= 20 && sum < 40){res = "You need some help, your results are alarming, select the most suitable day for an appointment";}
        else if(sum >= 40){res = "It's an emergency situation, you are seriously under threat";}
        model.addAttribute("results", res);
        return "results"; }
    @GetMapping("/home")
    public String AboutMe(Model model){ return "About me"; }
}
