package com.yidu.businessData.service;

import com.yidu.businessData.pojo.MarketData;

import java.util.HashMap;

/*
  @type:service
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
public interface MarketDataService {
    public HashMap selectMarKetDate(String marketId,String dateTime,int page,int limit);
    public int deleteMarKetDate(MarketData marketData);
    public int updateMarketDate(MarketData marketData);
    public int insertMarketDate(MarketData marketData);
    public HashMap selectMarKetDate1(int page,int limit,String searchMarketId,String searchTime);

}
