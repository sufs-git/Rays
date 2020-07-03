package com.feng.su.utils;

import org.springframework.stereotype.Component;

/**
 * 脱敏
 */
@Component("markUtils")
public class MarkUtils {
    public static String toMarkBookName(String source){

        if(source == null) {
            return  "";
        }

        if(source.length() == 1) {
            return source;
        }

        int cutLength = 1;

        if(source.length() > 9) {
            cutLength = 2;
        }

        return source.substring(0,cutLength) + "*" + source.substring(source.length() - cutLength - 1, source.length() - 1);
    }

    public static String toMarkAgentName(String name){
        if(name==null)
            return "";
        if(name.length()==2)
            return "*"+name.substring(1);
        if(name.length()==3)
            return name.substring(0,1)+"*"+name.substring(2);
        if(name.length()==4)
            return name.substring(0,1)+"*"+name.substring(3);
        return "";
    }
}
