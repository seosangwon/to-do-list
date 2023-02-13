package com.example.todolist.Service;

import com.example.todolist.domain.Member;
import com.example.todolist.Repsitory.MemberRepository;
import com.example.todolist.dao.MemberService;

public class MemberServiceImpl implements MemberService {

    //어떤 MemberRepository를 사용 할 것인지 아직 안정하고 선언만
    private MemberRepository memberRepository;

    @Override
    public void join(Member member) {
        //DB에다 회원 저장
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberIndex) {
        //DB에서 회원 찾기
        return memberRepository.findById(memberIndex);
    }
}
