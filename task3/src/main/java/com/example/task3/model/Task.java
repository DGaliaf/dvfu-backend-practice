package com.example.task3.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Task {
    private Integer id;
    private String title;
    private String description;
    private Timestamp created;
    private Timestamp updated;
}

