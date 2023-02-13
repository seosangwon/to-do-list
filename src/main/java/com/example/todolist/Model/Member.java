package com.example.todolist.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@jakarta.persistence.Entity
@Data
@ToString(exclude = "registerEntitySet")
@NoArgsConstructor
public class Member {

    //ID선언 Long이냐 Integer냐 -> 대부분  Entity에서는 Long
    //pk임
    @Id
    @Column(nullable = false)
    private Long MemberNumber;

    @Column(nullable = false)
    //회원 이름
    private String name;

    @Column(nullable = false)
    //회원가입 아이디
    private String id;

    @Column(nullable = false)
    //회원가입 비밀번호
    private String password;

    public Member(String id){this.id = id;}

}

