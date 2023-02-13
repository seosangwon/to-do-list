package com.example.todolist.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // 롬복 어노테이션 : Getter,Setter,toString등 따로 설정 안해줘도 되는 편리함이 있음
public class LoginForm {

    @NotBlank
    private String id;

    @NotBlank
    private String passwd;
}
