package com.yidu.systemManage.controller;

import com.yidu.systemManage.pojo.UserInfoPojo;
import com.yidu.systemManage.service.UserInfoService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 用户的biz层的实现类
 * date:2020.9.1 11:23
 * @author xbf
 * @version 1.0
 */
@RestController
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;

    //添加
    @RequestMapping("/insertUsers")
    public int insertUser(UserInfoPojo userInfoPojo){
        return userInfoService.insertUser(userInfoPojo);

    }





    //修改
    @RequestMapping("/updateUsers")
    public int updateUser(UserInfoPojo userInfoPojo){
        return userInfoService.updateUser(userInfoPojo);
    }

    //删除
    @RequestMapping("/deleteUsers")
    public int deleteUser(String userId){
        return userInfoService.deleteUser(userId);
    }
    //查询
    @RequestMapping("/selectUsers")
    public HashMap selectUser(int page,int limit,Integer status,String userName){

        HashMap hashMap=userInfoService.selectUser(page,limit,status,userName);
        int count=(int)hashMap.get("p_count");
        List<UserInfoPojo>userInfoPojoList=(List<UserInfoPojo>)hashMap.get("p_cursor");
        HashMap userMap=new HashMap();
        userMap.put("count",count);
        userMap.put("code",0);
        userMap.put("msg","");
        userMap.put("data",userInfoPojoList);
        return userMap;
    }
/*
    public List<UserInfoPojo>selectUser(){
        List<UserInfoPojo>userList=userInfoService.selectUser();
        System.out.println(userList);
        return userList;
    }*/


  /*  @RequestMapping("/insertUser")
    public List<UserPojo> insertUser(UserPojo userPojo){
        return userService.insertUserInfo(userPojo);
    }*/

}
