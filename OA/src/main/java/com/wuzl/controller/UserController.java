package com.wuzl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuzl.bean.User;
import com.wuzl.bean.jsonresult;
import com.wuzl.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static com.wuzl.utils.StringUtils.*;

@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserMapper us;


    @RequestMapping(value = "creat", produces = "text/plain;charset=utf-8", method = RequestMethod.POST)
    public String creatsUser(String workid, String name, int age, String sex, String birthdays, String phone, String email, String home) {
        System.out.println("添加user");
        Timestamp t = getTimeStamp(birthdays);
        Timestamp jointime = get_new_time();
        JSONObject js = null;
        User u1 = new User(workid, name, age, sex, t, phone, email, home, jointime);
        int i = us.creatsUser(u1);
        if (i != 0) {
            js = get_json(200, "添加新员工成功", 1, "");
        } else {
            js = get_json(300, "添加新员工失败", 1, "");
        }
        return JSON.toJSONString(js);
    }

    @RequestMapping(value = "delete", produces = "text/plain;charset=utf-8", method = RequestMethod.DELETE)
    public String deleteUser(int id) {
        System.out.println("删除user");
        JSONObject js = null;
        int i = us.deleteUser(id);
        System.out.println(i);
        if (i != 0) {
            js = get_json(200, "删除员工成功", 1, "");
        } else {
            js = get_json(300, "删除员工失败", 1, "");
        }
        return JSON.toJSONString(js);
    }

    @RequestMapping(value = "update", produces = "text/plain;charset=utf-8", method = RequestMethod.PUT)
    public String updateUser(String workid, String name, int age, String sex, String birthdays, String phone, String email, String home, int id) {
        System.out.println("修改user");
        JSONObject js = null;
        Timestamp t = getTimeStamp(birthdays);
        Timestamp jointime = get_new_time();
        User u1 = new User(workid, name, age, sex, t, phone, email, home, jointime);
        int i = us.updateUser(u1, id);
        System.out.println(i);
        if (i != 0) {
            js = get_json(200, "修改成功", 1, "");
        } else {
            js = get_json(300, "修改失败", 1, "");
        }
        return JSON.toJSONString(js);
    }


    @RequestMapping(value = "findbyid", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public String findbyid(int id) {
        System.out.println("查找user");
        JSONObject js = null;
        User u = us.findbyid(id);
        if (u != null) {
            js = get_json(200, "获取员工信息成功", 1, u);
        } else {
            js = get_json(300, "获取员工信息失败", 1, "");
        }
        System.out.println(u);
        return JSON.toJSONString(js);
    }



    @RequestMapping(value = "findall", produces = "text/plain;charset=utf-8", method = RequestMethod.GET)
    public String findall() {
        HttpServletRequest request = null;
        int p=(int)request.getAttribute("page");
        int l=(int)request.getAttribute("limit");
        int n=(p-1)*l;
        int m=n+l;
        System.out.println("查看所有user");
        JSONObject js = null;
        List<User> lu = us.findall(n,m);
        if (lu.size() != 0) {
            int c=us.findnum();
            js = new JSONObject();
            js = get_json(0, "获取员工列表成功", c, lu);

        } else {
            js = get_json(300, "获取员工列表失败", 0, "");
        }
        System.out.println(lu.toString());
        return JSON.toJSONString(js);
    }
}
