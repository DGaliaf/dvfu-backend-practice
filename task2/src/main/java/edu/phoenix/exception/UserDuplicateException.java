package edu.phoenix.exception;

public class UserDuplicateException extends Exception{
    public UserDuplicateException() {
        super("Указанный пользователь уже существует!");
    }
}
