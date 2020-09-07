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
    public HashMap selectTransactionData(int page,int limit);
    public int insertTransactionData(TransactionData transactionData);
    public int deleteTransactionData(String transactionDataId);
    public int updateTransactionData(TransactionData transactionData);
}
