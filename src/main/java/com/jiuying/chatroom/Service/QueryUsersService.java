package com.jiuying.chatroom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :查询用户,密码 服务类
 */
@Service
public class QueryUsersService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean queryusername(String username) {
        String sql = "SELECT username FROM usertable WHERE username = ?";
            //执行查询
        List<String> result = jdbcTemplate.queryForList(sql, String.class, username);
            //判断结果是否存在
        return !result.isEmpty();
    }
    public boolean querypassword(String username,String password) {
        String sql = "SELECT password FROM usertable WHERE username = ?";
        //执行查询
        List<String> result = jdbcTemplate.queryForList(sql, String.class, username);
        System.out.println("username: "+username+"\tpassword: "+result.get(0));
        return result.get(0).equals(password);
    }


}
