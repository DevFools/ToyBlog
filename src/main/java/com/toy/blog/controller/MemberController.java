package com.toy.blog.controller;

import com.toy.blog.domain.form.LoginForm;
import com.toy.blog.domain.form.NewMemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    @GetMapping("/member/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "/member/login";
    }

    @PostMapping("/member/logout")
    public String logout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        return "redirect:/";
    }

    @GetMapping("/member/new")
    public String createMember(Model model) {
        model.addAttribute("newMemberForm", new NewMemberForm());
        return "/member/createMember";
    }

    /** 검색 기능은 로그인과 회원가입 기능을 제작하고 제작 **/
}
