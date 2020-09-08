package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.SystemMenuMapper;
import com.yidu.permission.pojo.SystemMenu;
import com.yidu.permission.service.SystemMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单栏的服务层的实现类
 */
@Service
@Transactional
public class SystemMenuServiceImpl implements SystemMenuService {
    @Resource
    SystemMenuMapper systemMenuMapper;

    @Override
    public List<SystemMenu> selectSystemMenu() {
        List<SystemMenu> systemMenuList = systemMenuMapper.selectSystemMenu();
        return systemMenuList;
    }
}

