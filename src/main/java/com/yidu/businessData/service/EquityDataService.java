package com.yidu.businessData.service;

import com.yidu.businessData.pojo.EquityData;

import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-21
 * 权益数据设置服务器Service
 */
public interface EquityDataService {
    /**
     * 权益数据新增方法
     * @param equityData
     * @return
     */
    public int insertEquityData(EquityData equityData);

    /**
     * 权益数据删除方法
     * @param equityId
     * @return
     */
    public int  deleteEquityData(String  equityId);

    /**
     * 权益数据修该方法
     * @param equityData
     * @return
     */
    public int updateEquityData(EquityData equityData);

    /**
     * 权益数据查询方法
     * @param pageSize
     * @param page
     * @param equitiesType
     * @param equitiesExright
     * @return
     */
    public Map<String,Object> selectEquityData(String pageSize, String page ,String equitiesType , String equitiesExright);
}
