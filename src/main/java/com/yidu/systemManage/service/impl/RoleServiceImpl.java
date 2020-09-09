package com.yidu.systemManage.service.impl;

import com.yidu.systemManage.mapper.RoleMapper;
import com.yidu.systemManage.pojo.RolePojo;
import com.yidu.systemManage.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleMapper roleMapper;

    @Override
    public int insertRole(RolePojo rolePojo) {
        System.out.println("biz层注入的对象"+rolePojo);
        return roleMapper.insertRole(rolePojo);
    }

    @Override
    public int deleteRole(String roleId) {
        //拿到页面传递过来的id，截取字符串用数组接收
        String[] roleIds = roleId.split(",");
        //创建集合,用于接收数组中的数据
        ArrayList roleIdList = new ArrayList();
        for (int i = 0; i < roleIds.length; i++) {
            //将数组中的数据放入集合
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
