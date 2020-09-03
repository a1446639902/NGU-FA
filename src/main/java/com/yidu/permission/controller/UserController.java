package com.yidu.permission.controller;

import com.yidu.permission.pojo.UserInfo;
import com.yidu.permission.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("selectUser")
    public Map<String,Object> selectUser(String page,String limit){

        Map<String,Object> map = new HashMap<>();
        Map<String, Object> resultMap = userService.selectUser(page, limit);
        map.put("code",0);
        map.put("msg","");
        map.put("count",resultMap.get("count"));
        map.put("data",(ArrayList<UserInfo>)resultMap.get("userList"));
        return map;
    }

    @RequestMapping("deleteUser")
    public void deleteUser(int userId){
        System.out.println(userId);
        userService.deleteUser(userId);
    }

    @RequestMapping("insertUser")
    public void insertUser(UserInfo userInfo){

    }

}
