package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.LogMapper;
import com.yidu.permission.pojo.Log;
import com.yidu.permission.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public int deleteLog(String logId) {
        if(logId!=null && !logId.equals("")){
            //定义一个数组接收编号，切割字符串
            String[] split = logId.split(",");
            //定义一个整型集合
            List<String> logList = new ArrayList<String>();
            //循环数组
            for (String id : split) {
                //将数组循环的值添加到集合中，强转为整型
                logList.add(id);
            }
            return logMapper.deleteLog(logList);
        }else {
            return 0;
        }
    }


}
