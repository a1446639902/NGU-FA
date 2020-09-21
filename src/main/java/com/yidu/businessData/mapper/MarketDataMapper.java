package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.pojo.TransactionData;
import org.apache.ibatis.annotations.Mapper;


import java.util.HashMap;

/*
  @type:行情数据dao
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
@Mapper
public interface MarketDataMapper {
    public void selectMarKetDate(HashMap hashMap);
    public int deleteMarKetDate(MarketData marketData);
    public int updateMarketDate(MarketData marketData);
    public int insertMarketDate(MarketData marketData);
//上传
    int updateTransactionData(TransactionData transactionData);

}
