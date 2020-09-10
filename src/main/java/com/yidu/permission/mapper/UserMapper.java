package com.yidu.permission.mapper;

import com.yidu.permission.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * user的dao接口
 */
@Mapper
public interface UserMapper {

    public Integer selectUser1(Map<String,String> map);

}
