package com.yidu.businessData.service;

import com.yidu.businessData.pojo.EquityData;

import java.util.List;
/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置服务器Service
 */
public interface EquityDataService {
    public List<EquityData> selectEquityDataMapper();
}
