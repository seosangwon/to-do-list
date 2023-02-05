package com.example.todolist.Entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@jakarta.persistence.Entity
public class Member {

    //ID선언 Long이냐 Integer냐 -> 대부분  Entity에서는 Long
    private Long MemberNumber;

    //회원 이름
    private String name;

    //회원가입 아이디
    private String identifier;

    //회원가입 비밀번호
    private String password;

//생성자
    public Member(Long MemberNumber, String name, String identifier, String password) {
        this.MemberNumber = MemberNumber;
        this.name = name;
        this.identifier = identifier;
        this.password = password;
    }




    public Long getIndex() {
        return MemberNumber;
    }

    public void setId(Long MemberNumber) {
        this.MemberNumber = MemberNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdName() {
        return identifier;
    }

    public void setIdName(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }






}

