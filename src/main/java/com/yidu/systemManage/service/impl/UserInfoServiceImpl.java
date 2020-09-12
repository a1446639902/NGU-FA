package com.yidu.systemManage.service.impl;

import com.yidu.systemManage.mapper.UserInfoMapper;
import com.yidu.systemManage.pojo.UserInfoPojo;
import com.yidu.systemManage.service.UserInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用户的biz层的实现类
 * date:2020.9.11 11:23
 * @author xbf
 * @version 1.0
 */
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public int insertUser(UserInfoPojo userInfoPojo) {
        return userInfoMapper.insertUser(userInfoPojo);
    }

    @Override
    public int deleteUser(String userId) {
        String[] split = userId.split(",");
        List<String>userInfoList=new ArrayList<String>();
        for (String id:split) {
            userInfoList.add(id);
        }
        return userInfoMapper.deleteUser(userInfoList);
    }

    @Override
    public int updateUser(UserInfoPojo userInfoPojo) {
        return userInfoMapper.updateUser(userInfoPojo);
    }

   @Override
    public HashMap selectUser(int page, int limit,  String status, String userName) {
       String sql="";
       if (status!=null && !status.equals("")){
           sql=sql+" and status =" + status;
       }

       if(userName !=null && !userName.equals("")){
           sql=sql+" and userName like '%"+userName+"%'";
       }

        HashMap userMap=new HashMap();
        String tableName ="(select userId,userName,userPwd,r.roleId,r.roleName,u.status,userInfoDesc from userInfo u join role r on u.roleId=r.roleId)";
        userMap.put("p_tableName",tableName);
        userMap.put("p_condition",sql);
        userMap.put("p_pageSize",limit);
        userMap.put("p_page",page);
        userMap.put("p_count","count");
        userMap.put("p_cursor",null);
        userInfoMapper.selectUser(userMap);
        return userMap;
    }
/*    @Override
    public HashMap selectUser() {
        HashMap userMap=new HashMap();
        String tableName ="(select * from userInfo join role on userInfo.roleId=role.roleId)";
        userMap.put("p_tableName",tableName);
        userMap.put("p_condition","");
        userMap.put("p_pageSize",10);
        userMap.put("p_page",1);
        userMap.put("p_count",0);
        userMap.put("p_cursor",null);
        userInfoMapper.selectUser(userMap);
        return userMap;
    }*/
}
