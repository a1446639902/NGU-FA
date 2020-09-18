package com.yidu.permission.mapper;

import com.yidu.permission.pojo.Log;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 日志信息的mapper接口
 */
@Mapper
public interface LogMapper {
    public void insertLog(Log log);
    public List<Log> selectLog();
}
