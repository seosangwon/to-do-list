package com.example.todolist.domain.posts;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK Auto_Increment
    private Long id;

    @Column(length=500, nullable = false)
    private String title;

//    @Column(columnDefinition = "TEXT")
//    private String content;

    private String date;

    @Column
    private Boolean completed;

    @Column
    private String content;

    @Builder // Builder를 통하여 나중에 Set
    public Posts(String title, String date , Boolean completed){
        this.title=title;
        this.date=date;
        this.completed=completed;
    }

    public void update(String title, Boolean completed){
        this.title=title;
        this.completed = completed;
    }


}