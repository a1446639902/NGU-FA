package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.TransactionDataMapper;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

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
    public HashMap selectTransactionData(int page,int limit) {
        HashMap tranMap = new HashMap();
        tranMap.put("p_tableName", SysTableNameListUtil.TD);
        tranMap.put("p_condition","");
        tranMap.put("p_pageSize",limit);
        tranMap.put("p_page",page);
        tranMap.put("p_count",0);
        tranMap.put("p_cursor",null);
        transactionDataMapper.selectTransactionData(tranMap);
        return tranMap;
    }

    @Override
    public int insertTransactionData(TransactionData transactionData) {
        return transactionDataMapper.insertTransactionData(transactionData);
    }

    @Override
    public int deleteTransactionData(int transactionDataId) {
        return transactionDataMapper.deleteTransactionData(transactionDataId);
    }

    @Override
    public int updateTransactionData(TransactionData transactionData) {
        return transactionDataMapper.updateTransactionData(transactionData);
    }
}
