package com.yidu.systemManage.mapper;

import com.yidu.systemManage.pojo.RolePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 角色dao层的接口
 *
 * @author kangshao
 * @version 1.0
 * @Type:dao层接口
 * @time2020-9-1 22:30
 **/
@Mapper
public interface RoleMapper {

     int insertRole(RolePojo rolePojo);

     int deleteRole(ArrayList arrayList);

     int updateRole(RolePojo rolePojo);

     void selectRole(HashMap userMap);
}
