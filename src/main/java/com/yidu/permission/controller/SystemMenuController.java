package com.yidu.permission.controller;

import com.yidu.permission.pojo.SystemMenu;
import com.yidu.permission.service.SystemMenuService;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * 菜单栏的控制层
 */
@RestController
@RequestMapping("systemMenu")
public class SystemMenuController {
    @Resource
    SystemMenuService systemMenuService;

    /**
     *获取
     * @return 查询的菜单栏集合
     */
    @RequestMapping("selectSystemMenu")
    public List<SystemMenu> selectSystemMenu(HttpServletRequest request){
        //获取session里面存放的账户和密码
        HttpSession session = request.getSession(false);
        if (session==null){
            session= request.getSession();
        }
        String userName = (String) session.getAttribute("userName");
        String userPwd = (String) session.getAttribute("userPwd");
        //把账号和密码放入集合中
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("userName",userName);
        hashMap.put("userPwd",userPwd);
        //调用方法获取用户可控的菜单栏实体类集合
        List<SystemMenu> systemMenuList = systemMenuService.selectSystemMenu(hashMap);
        System.out.println("systemMenuList="+systemMenuList);
        //返回菜单栏实体类集合
        return systemMenuList;
    }
}
