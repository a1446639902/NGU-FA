package com.yidu.systemManage.service.impl;

import com.yidu.systemManage.mapper.RoleMapper;
import com.yidu.systemManage.pojo.RolePojo;
import com.yidu.systemManage.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 角色biz接口的实现类
 *
 * @author kangshao
 * @version 1.0
 * @Type:角色biz类的实现类
 * @time2020-9-1 22:54
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    public int insertRole(RolePojo rolePojo) {
        return roleMapper.insertRole(rolePojo);
    }

    @Override
    public int deleteRole(String roleId) {
        String[] roleIds = roleId.split(",");
        ArrayList roleIdList = new ArrayList();
        for (int i = 0; i < roleIds.length; i++) {
            roleIdList.add(roleIds[i]);
        }
        return roleMapper.deleteRole(roleIdList);
    }

    @Override
    public int updateRole(RolePojo rolePojo) {
        return roleMapper.updateRole(rolePojo);
    }

    @Override
    public HashMap selectRole(int page,int limit) {
        HashMap roleMap = new HashMap();
        //查询的表名
        roleMap.put("p_tableName","role");
        //查询的条件
        roleMap.put("p_condition","");
        //每页的条数
        roleMap.put("p_pageSize",limit);
        //第几页
        roleMap.put("p_page",page);
        //总条数
        roleMap.put("p_count",0);
        //游标标量
        roleMap.put("p_cursor",null);
        roleMapper.selectRole(roleMap);
        return roleMap;
    }
}
