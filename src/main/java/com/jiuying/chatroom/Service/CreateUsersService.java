package com.jiuying.chatroom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :创建用户服务类
 */
@Service

public class CreateUsersService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean createUsers(Integer id, String username, String password, String sex) {
        String sql = "INSERT INTO usertable (id, username, password, sex) VALUES (?, ?, ?, ?)";
        try {
            int rowsAffected = jdbcTemplate.update(sql, id, username, password, sex);
            return rowsAffected > 0;  // 如果有行受到影响，表示插入成功
        } catch (DataAccessException e) {
            e.printStackTrace();  // 打印异常信息
            return false;  // 出现异常，插入失败
        }
    }
    public Integer getMaxUserId() {
        String sql = "SELECT MAX(id) FROM usertable";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (DataAccessException e) {
            e.printStackTrace();  // 打印异常信息
            return null;  // 查询失败，返回 null
        }
    }
}
