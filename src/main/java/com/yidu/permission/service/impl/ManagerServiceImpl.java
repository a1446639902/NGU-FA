package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.ManagerMapper;
import com.yidu.permission.pojo.Manager;
import com.yidu.permission.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cai
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Resource
    ManagerMapper managerMapper;
    @Override
    public List<Manager> selectManager() {
        List<Manager> managerList = managerMapper.selectManager();
        return managerList;
    }
}
