package com.example.todolist.Controller;

import com.example.todolist.domain.Member;
import com.example.todolist.Service.LoginService;
import com.example.todolist.Service.PostsService;
import com.example.todolist.dto.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class SessionController {

    @Autowired
    private PostsService postsService;

    private final LoginService loginService;

    @GetMapping("/")
    public String toDoListPage(){

        return "/todoList/todoList";
    }

    @GetMapping("/join")
    public String joinPage(){
        return"join/join";
    }


/*
    @GetMapping("/login")
    public String loginPage(){
        return"login/login";
    }
*/
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        //세션날림
        request.getSession().removeAttribute(SessionConstants.LOGIN_MEMBER);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult,
                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "login/login";
        }

        Member loginMember = loginService.login(loginForm.getId(), loginForm.getPasswd());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }

        // 로그인 성공 처리
        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_MEMBER, loginMember);

        return "redirect:/class";
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
