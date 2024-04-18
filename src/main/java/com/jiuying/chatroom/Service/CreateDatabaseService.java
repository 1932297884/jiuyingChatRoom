package com.jiuying.chatroom.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiuying.chatroom.Repository.CreateDatabaseRepository;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :创建数据库服务类
 */
@Service
public class CreateDatabaseService {
    private final CreateDatabaseRepository createDatabaseRepository;
    @Autowired
    public CreateDatabaseService(CreateDatabaseRepository createDatabaseRepository) {
        this.createDatabaseRepository = createDatabaseRepository;
    }
    public void createTable(){
        createDatabaseRepository.createTable();
    }
}
