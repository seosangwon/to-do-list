package com.example.todolist.dto;

import com.example.todolist.Domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
 //   private String content;
    private String date;
    private Boolean completed;

    @Builder
    public PostsSaveRequestDto(String title, String date,Boolean completed){
        this.title=title;
        this.date=date;
        this.completed=completed;


    }
    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .date(date)
                .completed(completed)
                .build();
    }


}
