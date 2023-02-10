package com.example.todolist.Controller;

import com.example.todolist.Entity.Member;
import com.example.todolist.Service.LoginService;
import com.example.todolist.dto.LoginForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("loginForm",new LoginForm());
        return "login/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult,
                        HttpServletRequest request){
        if(bindingResult.hasErrors()){
            return "login/login";
        }

        Member loginMember = loginService.login(loginForm.getId(), loginForm.getPasswd());
        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/login";
        }else{
            HttpSession session = request.getSession();
            //세션에 loginMember속성을 loginMember라고 setting
            session.setAttribute("loginMember", loginMember);

            return "redirect:/class";
        }

    }
}
