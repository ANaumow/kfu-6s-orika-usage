package ru.itis.demo.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Group {

    private String groupName;

    private Student headman; // староста

    private List<Student> students;

}
