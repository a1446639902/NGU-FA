package com.yidu.businessData.service;

import com.yidu.businessData.pojo.TransactionData;

import java.util.HashMap;

/**
 * 交易数据表
 * @Type:服务层
 * @author Tmac
 * @time 2020/9/1  14:53
 * @version   1.0
 **/

public interface TransactionDataService {
    HashMap selectTransactionData(int page,int limit,String dateTime,String securitiesName);
    int insertTransactionData(TransactionData transactionData);
    int deleteTransactionData(String transactionDataId);
    int deleteTransactionDataTwo(String transactionDataId);
    int updateTransactionData(TransactionData transactionData);
}
