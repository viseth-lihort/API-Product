package org.example.demo_spring.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.demo_spring.model.Student;
import org.example.demo_spring.repository.StudentRepository;
import org.example.demo_spring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Integer id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            Student stud = studentOptional.get();
            stud.setFirstName(student.getFirstName());
            stud.setLastName(student.getLastName());
            stud.setPhoneNumber(student.getPhoneNumber());

            return studentRepository.save(stud);
        }else{
            throw new EntityNotFoundException("Student not found with id " + id);
        }
    }

    @Override
    public Optional<Student> findByPhoneNumber(String phoneNumber) {
        return studentRepository.findByPhoneNumber(phoneNumber);
    }

}
