package com.yidu.systemManage.mapper;

import com.yidu.systemManage.pojo.UserInfoPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 用户的dao层
 * date:2020.9.1 11:19
 * @author xbf
 * @version 1.0
 */
@Mapper
public interface UserInfoMapper {
    public int insertUser(UserInfoPojo userInfoPojo);
    public int deleteUser(int userId);
    public int updateUser(UserInfoPojo userInfoPojo);
    public void selectUser(HashMap hashMap);
}
