package com.example.campushub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {


    // 루트 경로 ("/")에 접근 시 로그인 페이지로 리다이렉트
    @GetMapping("/")
    public RedirectView home() {
        return new RedirectView("/login");  // 로그인 페이지로 리다이렉트
    }

    // 로그인 페이지 보여주기
    @GetMapping("/login")
    public String loginPage() {
        return "pages/login";  // login.html을 렌더링
    }

}
