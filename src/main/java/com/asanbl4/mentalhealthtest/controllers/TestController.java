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
    private Student get_LastStudent(){
        Iterable<Student> students = studentRepository.findAll();
        Student last_student = null;
        for(Student student: students){ last_student = student; }
        return last_student;
    }
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
        Student last_student = get_LastStudent();
        model.addAttribute("questionID", id);
        model.addAttribute("name", last_student.getName());
        model.addAttribute("question", getQuestions().get(id.intValue() - 1));
        return "test";
    }
    @PostMapping("/test/{id}")
    public String TestPos(@PathVariable(value = "id") Long id, @RequestParam("submitButton") String submitButtonValue, Model model){
        Student last_student = get_LastStudent();
        if (id.intValue() == 2){last_student.setQ1(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 3){last_student.setQ2(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 4){last_student.setQ3(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 5){last_student.setQ4(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 6){last_student.setQ5(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 7){last_student.setQ6(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 8){last_student.setQ7(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 9){last_student.setQ8(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 10){last_student.setQ9(Integer.parseInt(submitButtonValue));}
        if (id.intValue() == 11){
            last_student.setQ10(Integer.parseInt(submitButtonValue));
            studentRepository.save(last_student);
            return "redirect:/results/";
        }
        studentRepository.save(last_student);
        model.addAttribute("questionID", id);
        model.addAttribute("name", last_student.getName());
        model.addAttribute("question", getQuestions().get(id.intValue() - 1));
        return "test";
    }

    @GetMapping("/results/")
    public String results(Model model){
        Student last_student = get_LastStudent();
        model.addAttribute("name", last_student.getName());
        int sum = last_student.getQ1() + last_student.getQ2() + last_student.getQ3() + last_student.getQ4() + last_student.getQ5() + last_student.getQ6() + last_student.getQ7() + last_student.getQ8() + last_student.getQ9() + last_student.getQ10();
        if (sum < 20){ return "goodresults"; }
        return "redirect:/gender";
    }

    @GetMapping("/gender")
    public String gender(Model model){
        Student last_student = get_LastStudent();
        model.addAttribute("name", last_student.getName());
        return "gender";
    }

    @PostMapping("/gender")
    public String genderPos(@RequestParam(required = false) String gender, Model model){
        Student last_student = get_LastStudent();
        last_student.setGender(gender);
        studentRepository.save(last_student);
        return "redirect:/online";
    }

    @GetMapping("/online")
    public String online(Model model){
        Student last_student = get_LastStudent();
        model.addAttribute("name", last_student.getName());
        return "online";
    }

    @PostMapping("/online")
    public String onlinePos(@RequestParam("submitButton") String submitButtonValue, Model model){
        Student last_student = get_LastStudent();
        last_student.setIfOnline(Integer.parseInt(submitButtonValue));
        studentRepository.save(last_student);
        return "redirect:/lgbt";
    }

    @GetMapping("/lgbt")
    public String lgbt(Model model){
        Student last_student = get_LastStudent();
        model.addAttribute("name", last_student.getName());
        return "lgbt";
    }

    @PostMapping("/lgbt")
    public String lgbtPos(@RequestParam("submitButton") String submitButtonValue, Model model){
        Student last_student = get_LastStudent();
        last_student.setIfLgbt(Integer.parseInt(submitButtonValue));
        studentRepository.save(last_student);
        return "redirect:/religion";
    }

    @GetMapping("/religion")
    public String religion(Model model){
        Student last_student = get_LastStudent();
        model.addAttribute("name", last_student.getName());
        return "religion";
    }

    @PostMapping("/religion")
    public String religionPos(@RequestParam(required = false) String religion, Model model){
        Student last_student = get_LastStudent();
        last_student.setReligion(religion);
        studentRepository.save(last_student);
        return "redirect:/final";
    }

    @GetMapping("/final")
    public String finall(Model model){
        Student last_student = get_LastStudent();
        model.addAttribute("name", last_student.getName());
        return "final";
    }

}

