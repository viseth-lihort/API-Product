package org.example.demo_spring.controller;


import lombok.RequiredArgsConstructor;
import org.example.demo_spring.model.Student;
import org.example.demo_spring.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        return studentService.updateStudent(student, id);
    }

    @GetMapping
    public List<Student> findAllStudent(){
        return studentService.getAllStudent();
    }
    
    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Student> findStudentByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Student> student = studentService.findByPhoneNumber(phoneNumber);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
