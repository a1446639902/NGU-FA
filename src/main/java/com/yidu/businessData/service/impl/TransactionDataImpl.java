package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.TransactionDataMapper;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *交易数据表
 * @Type:服务层的实现类
 * @author Tmac
 * @time 2020/9/1  14:55
 * @version   1.0
 **/
@Service
public class TransactionDataImpl implements TransactionDataService {
    @Resource
    TransactionDataMapper transactionDataMapper;

    @Override
    public List<TransactionData> selectTransactionData() {
        return transactionDataMapper.selectTransactionData();
    }

    @Override
    public int insertTransactionData(TransactionData transactionData) {
        return transactionDataMapper.insertTransactionData(transactionData);
    }

    @Override
    public int deleteTransactionData(int tradeId) {
        return transactionDataMapper.deleteTransactionData(tradeId);
    }

    @Override
    public int updateTransactionData(TransactionData transactionData) {
        return transactionDataMapper.updateTransactionData(transactionData);
    }
}
