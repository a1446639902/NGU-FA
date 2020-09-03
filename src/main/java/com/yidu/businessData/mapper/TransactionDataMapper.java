package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.TransactionData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 交易数据表
 * @Type:dao层
 * @author Tmac
 * @time 2020/9/1  14:51
 * @version   1.0
 **/
@Mapper
public interface TransactionDataMapper {
    public List<TransactionData> selectTransactionData();
    public int insertTransactionData(TransactionData transactionData);
    public int deleteTransactionData(int tradeId);
    public int updateTransactionData(TransactionData transactionData);
}
