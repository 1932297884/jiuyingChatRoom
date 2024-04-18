package com.jiuying.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :页面跳转
 */

@Controller
//页面跳转
public class PageController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/Register")
    public String longinError(){
        return "Register";
    }
}
