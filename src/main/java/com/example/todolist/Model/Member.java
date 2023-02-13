package com.example.todolist.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString(exclude = "")
@NoArgsConstructor // 파라미터 없는 생성자 자동생성
@AllArgsConstructor //모든 파라미터 가진 생성자 자동생성
public class Member {
    //ID선언 Long이냐 Integer냐 -> 대부분  Entity에서는 Long
    @Id // PK지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // jpa 기본 키 매핑, IDENTITY 는 ID 자동 증가
    private Long MemberNumber;

    @Column(nullable = false,unique = true) //NOT NULL
    //회원 이름(닉네임)
    private String name;

    @Column(nullable = false, length=30, unique = true)
    //회원가입 아이디
    private String id;

    @Column(nullable = false)
    //회원가입 비밀번호
    private String password;
    public Member(String name, String id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }
    public Member(Long memberNumber){this.MemberNumber = memberNumber;}
    /**
     *  회원 정보 수정
     */
    // 회원이름, 비밀번호 수정
    public void modify(String name, String password){
        this.name=name;
        this.password=password;
    }
}

