package com.yidu.systemManage.service;

import com.yidu.systemManage.pojo.UserInfoPojo;

import java.util.List;

/**
 * 用户的biz层的接口
 * date:2020.9.1 11:19
 * @author xbf
 * @version 1.0
 */

public interface UserInfoService {
    public int insertUser(UserInfoPojo userInfoPojo);
    public void deleteUser(int userId);
    public int updateUser(UserInfoPojo userInfoPojo);
    public List<UserInfoPojo>selectUser();
}
