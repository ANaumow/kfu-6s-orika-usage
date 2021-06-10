package ru.itis.demo.services;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.domain.Group;
import ru.itis.demo.domain.Student;
import ru.itis.demo.dto.GroupDto;
import ru.itis.demo.dto.GroupWithStudentsDto;
import ru.itis.demo.dto.StudentDto;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private MapperFacade mapperFacade;

    private List<Student> students;
    private Group group;

    public StudentService() {
        this.students = Arrays.asList(
                Student.builder().firstname("Ivan").lastname("Ivanov").build(),
                Student.builder().firstname("Petr").lastname("Ivanov").build(),
                Student.builder().firstname("Ivan").lastname("Smirnov").build(),
                Student.builder().firstname("Petr").lastname("Smirnov").build(),
                Student.builder().firstname("Ivan").lastname("Petrov").build()
        );

        this.group = Group.builder()
                .students(students)
                .groupName("123")
                .headman(students.get(0))
                .build();

        students.forEach(student -> student.setGroup(group));
    }

    public StudentDto getStudent(Integer id) {
        Student student = students.get(id);
        return mapperFacade.map(student, StudentDto.class);
    }

    public List<StudentDto> getAllStudents() {
        return mapperFacade.mapAsList(this.students, StudentDto.class);
    }

    public GroupDto getGroup() {
        return mapperFacade.map(this.group, GroupWithStudentsDto.class);
    }
}
