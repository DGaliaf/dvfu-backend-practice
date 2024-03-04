package com.example.task3.dto;

import lombok.Data;

@Data
public class UpdateTaskDTO {
    private Integer id;
    private String title;
    private String description;
}
