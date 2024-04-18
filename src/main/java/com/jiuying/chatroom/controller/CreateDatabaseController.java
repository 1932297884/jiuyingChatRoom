package com.jiuying.chatroom.controller;

import com.jiuying.chatroom.Service.CreateDatabaseService;
import com.jiuying.chatroom.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ 作者：九影
 * @ 时间：2024/4/10 9:32
 * @ 作用 :创建所需数据库
 */
@RestController
public class CreateDatabaseController {
    @Autowired
    private CreateDatabaseService createDatabaseService;
    @RequestMapping("/createdatabase")
    public Result createTable(){
        createDatabaseService.createTable();
        return Result.success();
    }
}
