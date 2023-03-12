package com.example.todolist.Service;

import com.example.todolist.domain.Member;
import com.example.todolist.dao.LoginRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepo loginRepo;
    //return null 이면 로그인 실패
    public Member login(String id, String password){

        return loginRepo.findById(id) // db에서 로그인 정보를 가져옵니당.
                .filter(m->m.getPassword().equals(password)) //equals 메소드로 로그인 일치하면 로그인 아이디 그대로 리턴.
                .orElse(null);//없으면? null 리턴.
    }
}
