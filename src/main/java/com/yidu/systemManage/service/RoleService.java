package com.yidu.systemManage.service;


import com.yidu.systemManage.pojo.RolePojo;

import java.util.HashMap;

/**
 * 角色biz类的接口
 *
 * @author kangshao
 * @version 1.0
 * @Type:biz层接口
 * @time2020-9-1 22:32
 **/
public interface RoleService {

     int insertRole(RolePojo rolePojo);

     int deleteRole(String roleId);

     int updateRole(RolePojo rolePojo);

     HashMap selectRole(int page, int limit);
}
