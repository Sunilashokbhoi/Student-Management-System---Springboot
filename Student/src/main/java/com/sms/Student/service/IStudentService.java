package com.sms.Student.service;

import com.sms.Student.entity.Student;

import java.util.List;

public interface IStudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudent();
    public void deleteStudent(Long id);
}
