package com.yidu.businessDispose.service;

import com.yidu.businessDispose.pojo.Settlement;

import java.util.HashMap;

/**
 * @author Tmac
 * @version 1.0
 * @time 2020/9/8  11:35
 **/
public interface SettlementService {
    public HashMap selectSettlement(int page, int limit,String status,String dateTime,String transactionDataMode);
    public int insertSettlement(Settlement settlement);
    public int deleteSettlement(String transactionDataId);
    public int updateSettlement(Settlement settlement);
}
