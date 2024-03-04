package com.example.task1;

import com.example.task1.controller.Cat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class Task1Application {

    private static final List<Cat> cats = List.of(
            new Cat("Барсик", 3, "Маша"),
            new Cat("Бублик", 5, "Сергей"),
            new Cat("Черныш", 7, "Данил"),
            new Cat("Шава", 9, "Егор")
    );


    public static void main(String[] args) {
        printData();

//        SpringApplication.run(Task1Application.class, args);
    }

    private static void printData() {
        for (Cat cat : cats) {
            System.out.println("");
            System.out.println("=================================");
            System.out.println("Кот по имени: " + cat.getName());
            System.out.println("Ему: " + cat.getAge() + " лет!");
            System.out.println("Его хозяин/хозяйка: " + cat.getOwnerName());
            System.out.println("----");
            System.out.println(cat.getName() + " " + cat.meow());
            System.out.println(cat.getName() + " " + cat.guzzle());
            System.out.println(cat.getName() + " " + cat.jump());
            System.out.println("=================================");
            System.out.println("");
        }
    }

}
