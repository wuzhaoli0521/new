package com.wuzl.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.*;

public class StringUtils {
    /**
     * 1.String 转 时间戳
     */
    @Test
    public static Timestamp getTimeStamp(String s) {
        Timestamp tt = null;
//  tsStr = "2011-05-09 11:49:45";
        try {
            tt = Timestamp.valueOf(s);
            System.out.println(tt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tt);
        return tt;
    }



    /**
     * 2.获取当前时间的时间戳
     */
    @Test
    public static Timestamp get_new_time() {
        Timestamp d = new Timestamp(System.currentTimeMillis());
        return d;
    }

    /**
     * 3.将要return的数据放入Map并返回集合
     */
    @Test
    public static  JSONObject get_json(int code, String msg,int count, Object data) {

     JSONObject m=new JSONObject(new LinkedHashMap());
        m.put("code",code);
        m.put("msg",msg);
        m.put("count",count);
        m.put("data",data);
        return m;
    }
}
