package com.yidu.permission.service;

import com.yidu.permission.pojo.UserInfo;

import java.util.Map;


public interface UserService {
    Map<String,Object> selectUser(String page, String limit);
    public void deleteUser(int userId);
    public void insertUser(UserInfo userInfo);
}
