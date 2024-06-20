package org.example.demo_spring.service;

import org.example.demo_spring.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student updateStudent(Student student, Integer id);

    Optional<Student> findByPhoneNumber(String phoneNumber);

}
