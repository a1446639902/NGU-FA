package com.yidu.businessData.service;

import com.yidu.businessData.pojo.TransactionData;

import java.util.List;

/**
 * 交易数据表
 * @Type:服务层
 * @author Tmac
 * @time 2020/9/1  14:53
 * @version   1.0
 **/

public interface TransactionDataService {
    public List<TransactionData> selectTransactionData();
    public int insertTransactionData(TransactionData transactionData);
    public int deleteTransactionData(int tradeId);
    public int updateTransactionData(TransactionData transactionData);
}
