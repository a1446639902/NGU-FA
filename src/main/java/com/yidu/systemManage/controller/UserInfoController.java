package com.yidu.systemManage.controller;

import com.yidu.systemManage.pojo.UserInfoPojo;
import com.yidu.systemManage.service.UserInfoService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的biz层的实现类
 * date:2020.9.1 11:23
 * @author xbf
 * @version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;

    //添加
    @RequestMapping(value = "/insertUser",method = {RequestMethod.GET,RequestMethod.POST})
    public int insertUser(@ModelAttribute UserInfoPojo userInfoPojo){

        int i = userInfoService.insertUser(userInfoPojo);
        return i;
    }

    //修改
    @RequestMapping("/updateUser")
    public int updateUser(UserInfoPojo userInfoPojo){
        return userInfoService.updateUser(userInfoPojo);
    }

    //删除
    @RequestMapping("/deleteUser")
    public void deleteUser(){
        userInfoService.deleteUser(1);
    }
    //查询
    @RequestMapping("/selectUser")
/*    public HashMap selectUser(){
        List<UserInfoPojo> userList = userInfoService.selectUser();
        HashMap userMap=new HashMap();
        userMap.put("count",10);
        userMap.put("code",0);
        userMap.put("msg","");
        userMap.put("data",userList);
        return userMap;
    }*/

    public List<UserInfoPojo>selectUser(){
        List<UserInfoPojo>userList=userInfoService.selectUser();
        System.out.println(userList);
        return userList;
    }

   /* *//*查询用户*//*
    @RequestMapping("/insertUser")
    public List<UserPojo> insertUser(UserPojo userPojo){
        return userService.insertUserInfo(userPojo);
    }*/

}
