package com.example.todolist.Repsitory;

import com.example.todolist.Entity.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
