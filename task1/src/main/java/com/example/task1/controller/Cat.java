package com.example.task1.controller;

import org.springframework.stereotype.Component;

import java.io.Console;

public class Cat {
    private String name;
    private Integer age;
    private String ownerName;

    public Cat(String name, Integer age, String ownerName) {
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String meow() {
        return "Мяукает!";
    }

    public String jump() {
        return "Прыгает";
    }

    public String guzzle() {
        return "Лакает молоко!";
    }
}
