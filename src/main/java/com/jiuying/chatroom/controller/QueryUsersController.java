package com.jiuying.chatroom.controller;

import com.jiuying.chatroom.Service.QueryUsersService;
import com.jiuying.chatroom.pojo.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :登录验证
 */
@Slf4j
@RestController
public class QueryUsersController {

   @Autowired
    private QueryUsersService queryUsersService;

    @PostMapping("/Login")
    public Result toLogin(String user, String pwd, HttpSession httpSession) {
        Result result = new Result();
        httpSession.setMaxInactiveInterval(30*60);
        log.info(user+"登录验证中..");
        if(httpSession.getAttribute("user") != null){
            result.setCode(false);
            result.setMessage("不支持一个浏览器登录多个用户！");
            return result;
        }
        // 使用 queryUsersService 接口查询用户名是否存在
        if (!queryUsersService.queryusername(user)) {
            result.setCode(false);
            log.info(user+"验证失败");
            result.setMessage("登录失败，用户名不存在");
            return result;
        }
        // 使用 queryUsersService 接口查询密码是否正确
        if (!queryUsersService.querypassword(user, pwd)) {
            result.setCode(false);
            log.info(user+"验证失败");
            result.setMessage("登录失败，密码不正确");
            return result;
        }
        result.setCode(true);
        log.info(user+"登录验证成功");
        httpSession.setAttribute("user",user);
        return result;
    }

    @RequestMapping("/getUsername")
    public String getUsername(HttpSession httpSession){
        String username = (String) httpSession.getAttribute("user");;
        return username;
    }
}