package com.yidu.permission.service.impl;

import com.yidu.permission.mapper.LogMapper;
import com.yidu.permission.pojo.Log;
import com.yidu.permission.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public List<Log> selectLog() {
        List<Log> logList = logMapper.selectLog();
        return logList;
    }
}
