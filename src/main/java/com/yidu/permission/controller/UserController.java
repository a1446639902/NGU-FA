package com.yidu.permission.controller;


import com.yidu.permission.pojo.UserInfo;
import com.yidu.permission.service.UserService;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("selectUser")
    public Map<String,Object> selectUser(String page, String limit){
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

        userService.insertUser(new UserInfo());
    }

    @RequestMapping("checkLogin")
    public Map<String,Object> checkLogin(String userName, String userPwd, String fundId, HttpServletRequest request){
        System.out.println("userName="+userName+",userPwd="+userPwd+",fundId="+fundId);
        Map<String, Object> map = new HashMap<>();
        //调用数据库查询是否有该用户

        //先写死 给code赋值 1是登录成功 0是登录失败
        map.put("code",1);
        HttpSession session = request.getSession(false);
        if (session!=null){
            session=request.getSession();
        }
        session.setAttribute("userName",userName);
        session.setAttribute("fundId",fundId);
        return map;
    }

}
