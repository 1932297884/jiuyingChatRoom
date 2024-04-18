package com.jiuying.chatroom.config;

import com.jiuying.chatroom.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :配置拦截路径
 */

@Configuration
public class MvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private UserInterceptor userInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/main");
    }

}
