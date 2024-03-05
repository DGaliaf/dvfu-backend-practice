package com.example.task4.service;

import com.example.task4.model.Student;
import com.example.task4.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    public Student getStudentByID(Integer id) {
        return repository.getStudentByID(id);
    }

    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    public Student updateStudent(Student student) {
        return repository.updateStudent(student);

    }

    public Integer deleteStudent(Integer id) {
        return repository.deleteStudent(id);
    }
}
