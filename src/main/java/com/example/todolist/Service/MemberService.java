package com.example.todolist.Service;

import com.example.todolist.Entity.Member;
import com.example.todolist.Repsitory.MemberRepository;

import java.util.HashMap;
import java.util.Map;

public class MemberService implements MemberRepository {

    //Member 저장은 Hash 자료구조를 이용
    public static Map<Long,Member> store = new HashMap<>();


    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
