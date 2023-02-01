package com.example.todolist.Repsitory;

import com.example.todolist.Entity.Member;

public interface MemberRepository {

    //member를 저장
    void save(Member member);

    //Index (PK)를 이요하여 member를 찾는다.
    Member findById(Long memberIndex);
}
