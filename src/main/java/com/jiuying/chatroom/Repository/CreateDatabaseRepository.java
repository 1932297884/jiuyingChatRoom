package com.jiuying.chatroom.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :创建数据库接口实现类,这里我学的不太好,你们可以优化下
 */
@Repository
public class CreateDatabaseRepository {
    private final CreateDatabaseSQL createDatabaseSQL;
    @Autowired
    public CreateDatabaseRepository(CreateDatabaseSQL createDatabaseSQL) {
        this.createDatabaseSQL = createDatabaseSQL;
    }
    public void createTable(){
        createDatabaseSQL.createTable();
    }
}
