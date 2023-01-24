package com.example.todolist.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Member {

    @Id // PK 주입
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK생성을 DB에게 위임
    //ID선언 Long이냐 Integer냐 -> 대부분  Entity에서는 Long
    private Long Id;
    //회원 이름
    private String name;
    // list 제목
    private String title;

    // list 컨텐츠
    private String content;

    //file 첨부
    private String filename;



}
