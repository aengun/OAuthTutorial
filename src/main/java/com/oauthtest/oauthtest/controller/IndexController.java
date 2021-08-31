package com.oauthtest.oauthtest.controller;

import com.oauthtest.oauthtest.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

//    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
//        model.addAllAttributes("posts", postsService.findAllDesc());

        // CustomOAuth2UserService에서 로그인 성공시 세션에 SessinUser를 저장
        // 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있다.
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        // 세션에 값이 있을때만 model에 userName 등록
        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

//    @GetMapping({"", "/"})
//    public String getAuthorizationMessage(){
//        return "home";
//    }
//
//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @GetMapping({"/loginSuccess", "/board"})
//    public String loginSuccess(){
//        return "board";
//    }

}
