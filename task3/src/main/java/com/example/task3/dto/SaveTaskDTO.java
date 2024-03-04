package com.example.task3.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class SaveTaskDTO {
    @NonNull private String title;
    @NonNull private String description;
}
