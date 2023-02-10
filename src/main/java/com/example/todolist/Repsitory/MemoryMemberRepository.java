package com.example.todolist.Repsitory;

import com.example.todolist.Model.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    //Member 저장은 Hash 자료구조를 이용
    public static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        //key 값은
        store.put(member.getIndex(),member);
    }

    @Override
    public Member findById(Long memberIndex) {
        return store.get(memberIndex);
    }
}
