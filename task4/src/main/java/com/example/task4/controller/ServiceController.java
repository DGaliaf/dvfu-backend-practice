package com.example.task4.controller;

import com.example.task4.model.Student;
import com.example.task4.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class ServiceController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentByID(@PathVariable Integer id) {
        var response = studentService.getStudentByID(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        var response = studentService.saveStudent(student);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable("id") Integer id) {
        student.setId(id);

        var response = studentService.updateStudent(student);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        var response = studentService.deleteStudent(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

// TODO:
// 1. Добавить 4 метода GET,PUT,DELETE
// 2. Методы, эмулирующие ошибку, должны возвращать DTO с ошибками
