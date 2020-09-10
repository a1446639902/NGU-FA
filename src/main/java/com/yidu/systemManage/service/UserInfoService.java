package com.yidu.systemManage.service;

import com.yidu.systemManage.pojo.UserInfoPojo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 用户的biz层的接口
 * date:2020.9.1 11:19
 * @author xbf
 * @version 1.0
 */
@Service
public interface UserInfoService {
    public int insertUser(UserInfoPojo userInfoPojo);
    public int deleteUser(String userId);
    public int updateUser(UserInfoPojo userInfoPojo);
    public HashMap selectUser(/*int page,int limit,int searchstatus,String searchuserName*/);
}
