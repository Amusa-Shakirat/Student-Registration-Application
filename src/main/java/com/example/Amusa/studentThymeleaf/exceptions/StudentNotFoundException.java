package com.example.Amusa.studentThymeleaf.exceptions;

public class StudentNotFoundException extends RuntimeException{
    String message;

    public StudentNotFoundException(String message){

        super(message);
    }
}



