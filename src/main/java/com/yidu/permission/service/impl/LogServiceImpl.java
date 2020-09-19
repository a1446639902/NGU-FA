package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.LogMapper;
import com.yidu.permission.pojo.Log;
import com.yidu.permission.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Resource
    LogMapper logMapper;
    @Override
    public void insertLog(Log log) {
        logMapper.insertLog(log);
    }

    @Override
    public HashMap selectLog(int page, int limit, String userName) {
        String sql="";
        if(userName!=null && !userName.equals("")){
            sql=sql+" and userName like '%"+userName+"%'";
        }
        HashMap logMap = new HashMap();
        logMap.put("p_tableName","log");
        logMap.put("p_condition",sql);
        logMap.put("p_pageSize",limit);
        logMap.put("p_page",page);
        logMap.put("p_count",0);
        logMap.put("p_cursor",null);
        logMapper.selectLog(logMap);
        return logMap;
    }


}
