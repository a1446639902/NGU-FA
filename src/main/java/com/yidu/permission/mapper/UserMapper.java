package com.yidu.permission.mapper;

import com.yidu.permission.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * user的dao接口
 */
@Mapper
public interface UserMapper {

    public void selectUser(HashMap userMap);

    public void deleteUser(int userId);

    public void insertUser(UserInfo userInfo);


}
