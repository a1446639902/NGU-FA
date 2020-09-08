package com.yidu.systemManage.controller;

import com.yidu.systemManage.pojo.RolePojo;
import com.yidu.systemManage.service.RoleService;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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
    public Map<String,Object> selectUser(int page, int limit, HttpServletRequest request){

        String fundId = GetFundIdUtil.getFundId(request);
        System.out.println("fundId="+fundId);
        Map<String,Object> map = new HashMap<>();
        HashMap roleHashmap = roleService.selectRole(page, limit);
        //响应头
        map.put("msg","");
        map.put("code",0);
        //查询出来的条数
        map.put("count",roleHashmap.get("p_count"));
        //需要传递的游标变量
        map.put("data",roleHashmap.get("p_cursor"));

        //通过数据库查询出来的status，设置对应相应的状态
        List<RolePojo> cursor = (List<RolePojo>) roleHashmap.get("p_cursor");
        for (RolePojo value : cursor) {
            int status = value.getStatus();
            if (status==0){
                value.setStatusString("未启用");
            }else {
                value.setStatusString("启用");
            }
        }
        System.out.println("现在要输出游标变量"+cursor);
        return map;
    }
}
