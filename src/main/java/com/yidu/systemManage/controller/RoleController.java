package com.yidu.systemManage.controller;

import com.yidu.systemManage.pojo.RolePojo;
import com.yidu.systemManage.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 角色的控制类
 *
 * @author kangshao
 * @version 1.0
 * @Type:角色的控制类
 * @time2020-9-1 22:54
 **/
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    RoleService roleService;

    @RequestMapping("/insertRole")
    public int insertRole(RolePojo rolePojo){
        System.out.println("biz实现类注入的对象"+rolePojo);
        return roleService.insertRole(rolePojo);
    }

    @RequestMapping("/deleteRole")
    public int deleteRole(String roleId) {
        System.out.println(roleId);
        return roleService.deleteRole(roleId);
    }

    @RequestMapping("/updateRole")
    public int updateRole(RolePojo rolePojo) {
        return roleService.updateRole(rolePojo);
    }

    @RequestMapping("/selectRole")
    public Map<String,Object> selectUser(int page,int limit){
        Map<String,Object> map = new HashMap<>();
        HashMap roleHashmap = roleService.selectRole(page, limit);
        //响应头
        map.put("msg","");
        map.put("code",0);
        //查询出来的条数
        map.put("count",roleHashmap.get("p_count"));
        //需要传递的游标变量
        map.put("data",roleHashmap.get("p_cursor"));
        return map;
    }
}
