package com.yidu.businessData.service;

import com.yidu.businessData.pojo.MarketData;

import java.util.HashMap;

/*
  @type:service
 *@author wufeiyun
 * time 2020-9-2 15:36
  version 1.0
 * */
public interface MarketDataService {
    public HashMap selectMarKetDate();
    public int deleteMarKetDate(MarketData marketData);
    public int updateMarketDate(MarketData marketData);
    public int insertMarketDate(MarketData marketData);
    public HashMap selectMarKetDate1(String marketId,String dateTime);
}
