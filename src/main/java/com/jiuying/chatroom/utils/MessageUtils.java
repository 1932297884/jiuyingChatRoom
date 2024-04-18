package com.jiuying.chatroom.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiuying.chatroom.pojo.ResultMessage;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :封装发送的消息内容
 */

public class MessageUtils {
    public static String getMessage(boolean isSystemMessage,String fromName,Object message){
        try{
            ResultMessage resultMessage = new ResultMessage();
            resultMessage.setSystem(isSystemMessage);
            resultMessage.setMessage(message);
            if(fromName != null){
                resultMessage.setFromName(fromName);
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(resultMessage);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
