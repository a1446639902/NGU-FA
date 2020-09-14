package com.yidu.businessDispose.service;

import com.yidu.businessDispose.pojo.TaSettlement;

import java.util.Map;

/**
 * TA交易结算信息表服务类
 * @author 唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */


public interface TaSettlementService {
    /**
     * 查询
     */
    Map<String,Object> selectTaSettlement(String pageSize, String page, String dateTime,String transactionType,String status);

    /*
    修改
     */
    public int updateSettlement(String taSettlement);
    public int updateSettlementTwo(String taSettlement);
}