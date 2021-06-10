package ru.itis.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class GroupWithStudentsDto extends GroupDto {

    List<StudentDto> students;

}
