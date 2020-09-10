package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.UserMapper;
import com.yidu.permission.pojo.UserInfo;
import com.yidu.permission.service.UserService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.awt.desktop.SystemSleepEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public Integer selectUser1(Map<String,String> map) {
        Integer i = userMapper.selectUser1(map);
        if (i==null){
            i=0;
        }
        System.out.println("i="+i);
        return i;
    }

}
