package com.example.todolist.Controller;

import com.example.todolist.Domain.Member;
import com.example.todolist.Service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class SessionController {


    private  final PostsService postsService;


    @GetMapping("/")
    public String toDoListPage(){

        return "/todoList/todoList";
    }

    @GetMapping("/join")
    public String joinPage(){
        return"join/join";
    }




    @GetMapping("/login")
    public String loginPage(){
        return"login/login";
    }











}
