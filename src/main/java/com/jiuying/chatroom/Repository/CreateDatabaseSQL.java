package com.jiuying.chatroom.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


/**
 * @ 作者：九影
 * @ 时间：2024/4/19 13:32
 * @ 作用 :sql创建数据表
 */
@Mapper
public interface CreateDatabaseSQL {
    @Update("CREATE TABLE IF NOT EXISTS `test`.`UserTable` (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "username VARCHAR(50) NOT NULL, " +
            "password VARCHAR(100) NOT NULL, " +
            "sex VARCHAR(10) NOT NULL)")
    public void createTable();
}
