package ru.itis.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

    private String firstname;

    private String lastname;

    private Group group;

}
