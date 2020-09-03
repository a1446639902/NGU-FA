package com.yidu.systemManage.service.impl;

import com.yidu.systemManage.mapper.UserInfoMapper;
import com.yidu.systemManage.pojo.UserInfoPojo;
import com.yidu.systemManage.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的biz层的实现类
 * date:2020.9.1 11:23
 * @author xbf
 * @version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public int insertUser(UserInfoPojo userInfoPojo) {
        return userInfoMapper.insertUser(userInfoPojo);
    }

    @Override
    public void deleteUser(int userId) {
        userInfoMapper.deleteUser(userId);
    }

    @Override
    public int updateUser(UserInfoPojo userInfoPojo) {
          return userInfoMapper.updateUser(userInfoPojo);
    }

    @Override
    public List<UserInfoPojo> selectUser() {
        return userInfoMapper.selectUser();
    }
}
