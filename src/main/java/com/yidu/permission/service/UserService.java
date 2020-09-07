package com.yidu.permission.service;

import com.yidu.permission.pojo.UserInfo;

import java.util.Map;


public interface UserService {
    Integer selectUser1(Map<String,String> map);
    public void deleteUser1(int userId);
    public void insertUser1(UserInfo userInfo);
}
