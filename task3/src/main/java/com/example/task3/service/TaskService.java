package com.example.task3.service;

import com.example.task3.dto.SaveTaskDTO;
import com.example.task3.dto.UpdateTaskDTO;
import com.example.task3.model.Task;
import com.example.task3.repository.TaskDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskDAO repository;


    public List<Task> getAllTask() {
        return repository.getAllTask();
    }

    public Task getTaskByID(Integer id) {
        return repository.getTaskByID(id);
    }

    public Task saveTask(SaveTaskDTO saveTaskDTO) {
        return repository.saveTask(saveTaskDTO);
    }

    public Task updateTask(UpdateTaskDTO updateTaskDTO) {
        return repository.updateTask(updateTaskDTO);
    }

    public Integer deleteTaskByID(Integer id) {
        return repository.deleteTaskByID(id);
    }
}
