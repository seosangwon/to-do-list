package com.example.todolist.dto;

import com.example.todolist.domain.posts.Posts;
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

    private String content;

    @Builder
    public PostsSaveRequestDto(String title, String date,Boolean completed, String content){
        this.title=title;
        this.date=date;
        this.completed=completed;
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .date(date)
                .completed(completed)
                .build();
    }


}
