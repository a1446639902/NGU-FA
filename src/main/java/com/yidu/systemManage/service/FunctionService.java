package com.yidu.systemManage.service;

import com.yidu.systemManage.pojo.FunctionPojo;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能的biz层
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public interface FunctionService {
    //查询功能
    HashMap selectFunction();

    //修改功能
    int updateFuction(FunctionPojo functionPojo);
}
