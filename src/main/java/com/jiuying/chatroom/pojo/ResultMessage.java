package com.jiuying.chatroom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :用户间传送的消息
 */
public class ResultMessage {
    private boolean isSystem;
    private String fromName;
    //private String toName;
    private Object message;
}
