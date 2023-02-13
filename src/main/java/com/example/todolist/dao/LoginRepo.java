package com.example.todolist.dao;

import com.example.todolist.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//이 클래스는 리포지토리 역할을 하고 컴포넌트 이기떄문에 컴포넌트 스캔할때 빈에 등록합니다.
@Repository
public interface LoginRepo extends JpaRepository<Member, String> {
    Optional<Member> findById(String id);
    Optional<Member> findById(Long MemberNumber);
}
