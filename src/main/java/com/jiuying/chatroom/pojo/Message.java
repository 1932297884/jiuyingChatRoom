package com.jiuying.chatroom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :消息类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    private String toName;
    private String message;
    private String fromName;
}
