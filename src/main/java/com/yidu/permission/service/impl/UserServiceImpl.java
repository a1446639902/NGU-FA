package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.UserMapper;
import com.yidu.permission.pojo.UserInfo;
import com.yidu.permission.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public Map<String,Object> selectUser(String page, String limit) {
        int vPage = 0;
        if (page!=null && !page.equals("")){
            vPage = Integer.parseInt(page);
        }
        int vLimit = 0;
        if (limit!=null && !limit.equals("")){
            vLimit = Integer.parseInt(limit);
        }
        HashMap userMap = new HashMap();
        userMap.put("p_tableName","userInfo");
        userMap.put("p_condition","");
        userMap.put("p_pageSize",vLimit);
        userMap.put("p_page",vPage);
        userMap.put("p_count",0);
        userMap.put("p_cursor",null);
        userMapper.selectUser(userMap);
        List<UserInfo> userList = (List<UserInfo>) userMap.get("p_cursor");
        Map<String,Object> resultHashMap = new HashMap<>();
        resultHashMap.put("count",userMap.get("p_count"));
        resultHashMap.put("userList",userList);
        return resultHashMap;
    }

    @Override
    public void deleteUser(int userId) {

    }

    @Override
    public void insertUser(UserInfo userInfo) {

    }

}
