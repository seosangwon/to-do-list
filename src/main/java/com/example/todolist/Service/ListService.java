package com.example.todolist.Service;

import com.example.todolist.Entity.Member;
import com.example.todolist.Repsitory.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ListService {

    @Autowired //DI 의존성 주입, 스프링이 자동으로 주입해준다.
    private ListRepository listRepository; // ListRepositoryd의 기능(setter,getter,findbyone...)등 사용하기 위해

    //to-do-list 작성
    public void write(Member member){

        listRepository.save(member); // Repository의 save기능 사용

    }


}
