package com.yidu.businessData.service;

import com.yidu.businessData.pojo.EquityData;

import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置服务器Service
 */
public interface EquityDataService {
    public int insertEquityData(EquityData equityData);
    public int  deleteEquityData(String  equityId);
    public int updateEquityData(EquityData equityData);
    public Map<String,Object> selectEquityData(String pageSize, String page);
}
