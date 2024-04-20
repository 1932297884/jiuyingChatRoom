package com.jiuying.chatroom.controller;

import com.jiuying.chatroom.Service.CreateUsersService;
import com.jiuying.chatroom.Service.QueryUsersService;
import com.jiuying.chatroom.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :注册
 */
@RestController
public class CreateUsersController {

    @Autowired
    private QueryUsersService queryUsersService;
    @Autowired
    private CreateUsersService createUsersService;

    @PostMapping("/Register")
    public Result register(@RequestParam(name="username") String username , @RequestParam(name="password") String password, @RequestParam(name = "sex") String sex){
        Integer id;
        if(createUsersService.getMaxUserId()==null){
            id=1;
        }else{
            id = createUsersService.getMaxUserId() + 1;
        }
        if (queryUsersService.queryusername(username)) {
            return Result.error("用户已存在");
        } else if (username == null || password == null) {
            return Result.error("用户名或者密码为空");
        } else {
            boolean createUserResult = createUsersService.createUsers(id, username, password, sex);
            if (!createUserResult) {
                return Result.error("注册失败_未知错误");
            }
            return Result.success("注册成功");
        }
    }
}
