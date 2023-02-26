package com.example.todolist.Controller;

import com.example.todolist.Domain.Member;
import com.example.todolist.Service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class SessionController {

    @Autowired
    private PostsService postsService;


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

    @GetMapping("/")
    public String toDolist(){
        return "todoList/todoList";
    }

    /**
       @GetMapping("/")
       public String home(){
           return "redirect:/login";
       }

       @GetMapping("/list")
       public String showList(Model model ,
                              @SessionAttribute(name = "loginId") Member member){
           if(member != null){
               //리스트를 보여줍니다.

               return "todoList/todoList";
           }else{
               return "redirect:/login";
           }
                              }
       **/








}
