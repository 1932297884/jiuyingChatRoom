package com.jiuying.chatroom.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :拦截器
 */

@Component
@Slf4j
public class UserInterceptor implements HandlerInterceptor {

    public static Map<String, String> onLineUsers = new ConcurrentHashMap<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        String username = (String) httpSession.getAttribute("user");
        log.info(username+"\t进入拦截器");
        if(username != null && !onLineUsers.containsKey(username)){
            onLineUsers.put(username,username);
            log.info("已进入拦截器判断");
            log.info("已存储的用户01"+onLineUsers);
            return true;
        }else {
            log.info("已存储的用户02" + onLineUsers);
            log.info("未进入判断，进行重定向");
            httpSession.removeAttribute("user");
            return false;
        }
    }
}
