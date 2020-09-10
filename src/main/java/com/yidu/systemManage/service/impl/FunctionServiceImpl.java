package com.yidu.systemManage.service.impl;

import com.yidu.systemManage.mapper.FunctionMapper;
import com.yidu.systemManage.pojo.FunctionPojo;
import com.yidu.systemManage.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * biz接口的实现类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Service
public class FunctionServiceImpl implements FunctionService {
    @Resource
    FunctionMapper functionMapper;

    //查询功能
    @Override
    public HashMap selectFunction() {
        HashMap hashMap = new HashMap();
        //传递表名
        hashMap.put("p_tableName","function");
        //传递游标变量
        hashMap.put("p_cursor",null);
        functionMapper.selectFunction(hashMap);
        return hashMap;
    }

    //修改功能
    @Override
    public int updateFuction(FunctionPojo functionPojo) {
        return  functionMapper.updateFuction(functionPojo);
    }
}
