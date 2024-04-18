package com.jiuying.chatroom.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @ 作者：九影
 * @ 时间：2024/4/19 1:32
 * @ 作用 :返回值类
 */

@Data
@AllArgsConstructor  //全参构造注释,为实体类生成除了static修饰的字段之外带有各参数的构造器方法。
@NoArgsConstructor   //无参构造注释

public class Result {
    private boolean code;
    private String message;

    public static Result success() {
        return new Result(true, null);
    }
    public static Result success(String message) {
        return new Result(true, message);
    }
    public static Result error(String message) {
        return new Result(false, message);
    }
}
