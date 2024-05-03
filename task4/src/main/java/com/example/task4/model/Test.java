package com.example.task4.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity(name = "test")
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

}