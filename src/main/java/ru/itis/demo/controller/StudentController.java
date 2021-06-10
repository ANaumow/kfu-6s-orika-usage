package ru.itis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.demo.domain.Group;
import ru.itis.demo.dto.GroupDto;
import ru.itis.demo.dto.StudentDto;
import ru.itis.demo.services.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public StudentDto getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/group")
    public GroupDto getGroup() {
        return studentService.getGroup();
    }

}
