package com.example.todolist.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginForm {

    @NotBlank
    private String id;

    @NotBlank
    private String passwd;
}
