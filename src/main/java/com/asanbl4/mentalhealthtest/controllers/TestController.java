package com.asanbl4.mentalhealthtest.controllers;

import com.asanbl4.mentalhealthtest.models.Student;
import com.asanbl4.mentalhealthtest.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class TestController {

    public ArrayList<String> getQuestions(){
        ArrayList<String> questions = new ArrayList<>();
        questions.add("Do you often feel anxiety or worry that interferes with your daily life?");
        questions.add("Do you have difficulties with concentration or memory that affect your studies?");
        questions.add("Do you experience problems with controlling anger or aggression?");
        questions.add("Do you often feel lonely or isolated from others?");
        questions.add("Do you frequently experience sadness or insomnia?");
        questions.add("Have you noticed changes in your appetite or weight related to your emotional state?");
        questions.add("Are you concerned about excessive alcohol, nicotine, or substance use?");
        questions.add("Do you feel worthless or hopeless?");
        questions.add("Does perfectionism interfere with your ability to fulfill responsibilities?");
        questions.add("Do you sense that your emotions and mental well-being are affecting your academic performance?");
        return questions;
    }
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/test/{id}")
    public String TestMain(@PathVariable(value = "id") Long id, Model model) {
        Iterable<Student> students = studentRepository.findAll();
        Student last_student = null;
        for(Student student: students){ last_student = student; }
        assert last_student != null;
        model.addAttribute("questionID", id);
        model.addAttribute("name", last_student.getName());
        model.addAttribute("question", getQuestions().get(id.intValue() - 1));
        return "test";
    }
    @PostMapping("/test/{id}")
    public String TestPos(@PathVariable(value = "id") Long id, @RequestParam("submitButton") String submitButtonValue, Model model){
        Iterable<Student> students = studentRepository.findAll();
        Student last_student = null;
        for(Student student: students){ last_student = student; }
        assert last_student != null;
        if (id.intValue() == 2){last_student.setQ1(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 3){last_student.setQ2(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 4){last_student.setQ3(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 5){last_student.setQ4(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 6){last_student.setQ5(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 7){last_student.setQ6(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 8){last_student.setQ7(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 9){last_student.setQ8(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 10){last_student.setQ9(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 11){last_student.setQ10(Integer.parseInt(submitButtonValue));}
        studentRepository.save(last_student);
        if (id.intValue() == 11){return "redirect:/results";}
        model.addAttribute("questionID", id);
        model.addAttribute("name", last_student.getName());
        model.addAttribute("question", getQuestions().get(id.intValue() - 1));
        return "test";
    }
}

