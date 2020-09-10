package com.yidu.permission.controller;

import com.yidu.permission.pojo.SystemMenu;
import com.yidu.permission.service.SystemMenuService;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public List<SystemMenu> selectSystemMenu(){
        List<SystemMenu> systemMenuList = systemMenuService.selectSystemMenu();
        System.out.println("systemMenuList="+systemMenuList);
        return systemMenuList;
    }
}
