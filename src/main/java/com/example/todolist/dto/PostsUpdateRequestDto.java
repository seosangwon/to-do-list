package com.example.todolist.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;

    //update된 제목과 내용의 dto
    @Builder
    public PostsUpdateRequestDto(String title,String content){
        this.title=title;
        this.content=content;
    }

}
