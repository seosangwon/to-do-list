package com.example.todolist.Repsitory;

import com.example.todolist.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    //Member 저장은 Hash 자료구조를 이용
    public static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        //PK 값
        store.put(member.getMemberNumber(),member);
    }

    //pk : memberNumber에 따른 멤버ID찾기
    @Override
    public Member findById(Long memberNumber) {

        return store.get(memberNumber);
    }
}
