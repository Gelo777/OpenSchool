package com.example.testservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class Employee {

    private Long id;

    private String firstName;

    private String lastName;
}
