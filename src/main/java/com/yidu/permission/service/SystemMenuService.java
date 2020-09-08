package com.yidu.permission.service;

import com.yidu.permission.pojo.SystemMenu;

import java.util.List;

/**
 * 菜单栏的服务层
 */
public interface SystemMenuService {
    public List<SystemMenu> selectSystemMenu();
}
