package com.example.task3.controller;

import com.example.task3.dto.SaveTaskDTO;
import com.example.task3.dto.UpdateTaskDTO;
import com.example.task3.exception.AppError;
import com.example.task3.model.Task;
import com.example.task3.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable Integer id) {
        try {
            var response = taskService.getTaskByID(id);

            if (response == null) {
                throw new Exception();
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Задание с ID: " + id + " не найдено"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Task saveTask(@RequestBody SaveTaskDTO saveTaskDTO) {
        return taskService.saveTask(saveTaskDTO);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@RequestBody UpdateTaskDTO updateTaskDTO, @PathVariable("id") Integer id) {
        try {
            updateTaskDTO.setId(id);

            var response = taskService.updateTask(updateTaskDTO);

            if (response == null) {
                throw new Exception();
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Задание, которое вы пытаетесь обновить, с ID: " + id + " не найдено"),
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
        try {
            Integer code = taskService.deleteTaskByID(id);

            if (code == -1) {
                throw new Exception();
            }

            return new ResponseEntity<>(new AppError(HttpStatus.OK.value(),
                    "Задание удалено"),
                    HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                    "Задание, которое вы пытаетесь удалить, с ID: " + id + " не найдено"),
                    HttpStatus.NOT_FOUND);
        }
    }
}
