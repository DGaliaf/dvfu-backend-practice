package com.example.task3.repository;

import com.example.task3.dto.SaveTaskDTO;
import com.example.task3.dto.UpdateTaskDTO;
import com.example.task3.model.Task;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.*;

@Repository
public class TaskDAO {
    private Integer currentID = 1;
    private final List<Task> TASKS = new ArrayList<>();

    public List<Task> getAllTask() {
        return TASKS;
    }

    public Task getTaskByID(Integer id) {
        return TASKS.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task saveTask(SaveTaskDTO saveTaskDTO) {
        Task task = Task.builder()
                .id(currentID++)
                .title(saveTaskDTO.getTitle())
                .description(saveTaskDTO.getDescription())
                .created(new Timestamp(System.currentTimeMillis()))
                .updated(new Timestamp(System.currentTimeMillis()))
                .build();

        TASKS.add(task);

        TASKS.sort(Comparator.comparing(Task::getId));

        return task;
    }

    public Task updateTask(UpdateTaskDTO updateTaskDTO) {
        for (int i = 0; i < TASKS.size(); i++) {
            Task task = TASKS.get(i);

            if (task.getId().equals(updateTaskDTO.getId())) {
                Task updatedTask = Task
                        .builder()
                        .id(updateTaskDTO.getId())
                        .created(task.getCreated())
                        .updated(new Timestamp(System.currentTimeMillis()))
                        .title(updateTaskDTO.getTitle())
                        .description(updateTaskDTO.getDescription())
                        .build();

                TASKS.set(i, updatedTask);

                return task;
            }
        }

        return null;
    }

    public Integer deleteTaskByID(Integer id) {
        var task = getTaskByID(id);

        if (task != null) {
            TASKS.remove(task);

            return 1;
        }

        return -1;
    }
}
