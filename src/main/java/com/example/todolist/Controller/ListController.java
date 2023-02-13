package com.example.todolist.Controller;

import com.example.todolist.Model.Member;
import com.example.todolist.Repsitory.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class ListController {

    //@Autowired // Service 의존성 주입 -> 따로 Service 클래스 생성을 안해도 , 사용 가능
    //private MemoryMemberRepository listService;
    //필드 di에서 생성자 di(권장)으로 바꿈.
    private final MemoryMemberRepository listService;

    //list url 받을 시 list 리소스 return
    //DB에서 list를 받아서 페이지에 모으는 작업 필요
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

    //write 페이지
    @GetMapping("to_do_list/write")
    public String to_do_list_Write(){
        return "write";
    }
}
