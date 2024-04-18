package com.jiuying.chatroom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :websocket要做的配置类
 */
@Configuration

public class WebSocketConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
