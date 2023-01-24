package com.example.todolist.Controller;

import com.example.todolist.Service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @Autowired // Service 의존성 주입 -> 따로 Service 클래스 생성을 안해도 , 사용 가능
    private ListService listService;

    //list url 받을 시 list 리소스 return
    //DB에서 list를 받아서 페이지에 모으는 작업 필요
    @GetMapping("/to_do_list/list")
    public String to_do_list_List(){
        return "list";
    }

    //write 페이지
    @GetMapping("to_do_list/write")
    public String to_do_list_Write(){

        return "write";
    }



}
