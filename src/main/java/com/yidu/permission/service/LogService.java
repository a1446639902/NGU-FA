package com.yidu.permission.service;

import com.yidu.permission.pojo.Log;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 日志信息的服务类
 */
@Service
public interface LogService {
    public void insertLog(Log log);
    public HashMap selectLog(int page, int limit, String userName);
}
