package com.sms.Student.controller;

import com.sms.Student.entity.Student;
import com.sms.Student.service.IStudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")  //allow request from frontend
@RequestMapping("/api/students")
public class StudentController {
    private final IStudentService service;
    public StudentController(IStudentService service){
        this.service = service;
    }
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @GetMapping
    public List<Student> getStudents(){
        return service.getAllStudent();
    }
    @DeleteMapping("/{id}")
    public void deletStudent(@PathVariable Long id){
        service.deleteStudent(id);
    }
}
