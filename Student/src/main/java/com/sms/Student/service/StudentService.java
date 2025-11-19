package com.sms.Student.service;

import com.sms.Student.entity.Student;
import com.sms.Student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService{

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Student saveStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return repo.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}
