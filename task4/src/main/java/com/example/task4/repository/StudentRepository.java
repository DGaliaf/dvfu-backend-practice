package com.example.task4.repository;

import com.example.task4.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class StudentRepository {
    private Integer currentID = 1;
    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    public Student getStudentByID(Integer id) {
        return STUDENTS.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);

        STUDENTS.sort(Comparator.comparing(Student::getId));

        return student;
    }

    public Student updateStudent(Student student) {
        for (int i = 0; i < STUDENTS.size(); i++) {
            if (STUDENTS.get(i).getId().equals(student.getId())) {
                STUDENTS.set(i, student);

                return student;
            }
        }

        return null;
    }

    public Integer deleteStudent(Integer id) {
        var student = getStudentByID(id);

        if (student != null) {
            STUDENTS.remove(student);

            return 1;
        }

        return -1;
    }
}
