package org.example.demo_spring.repository;

import org.example.demo_spring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByPhoneNumber(String phoneNumber);
}
