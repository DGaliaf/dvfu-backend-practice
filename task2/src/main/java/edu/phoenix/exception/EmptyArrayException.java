package edu.phoenix.exception;

public class EmptyArrayException extends Exception{
    public EmptyArrayException() {
        super("База данных пуста, удалять нечего!");
    }
}

