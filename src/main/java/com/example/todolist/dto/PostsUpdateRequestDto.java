package com.example.todolist.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
  //  private String content;
    private String date;
    private Boolean completed;

    private String content;

    //update된 제목과 내용의 dto
    @Builder
    public PostsUpdateRequestDto(String title,String date, Boolean completed, String content){
        this.title=title;
        this.date= date;
        this.completed=completed;
        this.content = content;
    }

}
