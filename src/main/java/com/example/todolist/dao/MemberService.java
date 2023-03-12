package com.example.todolist.dao;

import com.example.todolist.domain.Member;

public interface MemberService {

    //회원가입 , join은 내장된 메소드
    void join (Member member);

    //회원조회 MemberIndex를 받으면 찾은 Member 로 retrun
    Member findMember(Long memberIndex);
}

