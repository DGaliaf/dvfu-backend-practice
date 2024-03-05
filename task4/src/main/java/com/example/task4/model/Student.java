package com.example.task4.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    Integer id;
    String name;
    Integer cls;
    String email;
}
