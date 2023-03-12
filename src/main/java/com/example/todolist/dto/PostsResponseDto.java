package com.example.todolist.dto;

import com.example.todolist.domain.posts.Posts;
import lombok.Getter;

//DB에서 꺼낸 Entity의 값을 Dto로 바꾼다..
@Getter
public class PostsResponseDto {

     private Long id;
     private String title;
     private String content;

     //Posts(Entity)에서 정보를 가져온다.(getter)
     public PostsResponseDto(Posts entity){
         this.id= entity.getId();;
         this.title=entity.getTitle();
         this.content=entity.getContent();
     }

}



