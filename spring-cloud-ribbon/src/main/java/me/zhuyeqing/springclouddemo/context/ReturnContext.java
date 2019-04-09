package me.zhuyeqing.springclouddemo.context;

import lombok.Data;

/**
 *  The context is for package Response content and uniform return format
 */
@Data
public class ReturnContext {
     int code;
     String message;
     Object content;

    public ReturnContext(int code, Object content) {
        this.code = code;
        this.content = content;
    }

    public ReturnContext(int code) {
        this.code = code;
    }

    public static ReturnContext Success(){
         return new ReturnContext(0,null);
     }
}
