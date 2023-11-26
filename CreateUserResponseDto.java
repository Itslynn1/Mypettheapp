package com.example.mypettheapp.api.dto;

public class CreateUserResponseDto {
    private int id;  // предположим, что id - это целочисленное значение

    // конструкторы

    // геттер для id
    public int getId() {
        return id;
    }

    // сеттер для id (если необходимо)
    public void setId(int id) {
        this.id = id;
    }
}