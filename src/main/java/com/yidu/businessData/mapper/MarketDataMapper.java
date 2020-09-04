package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.MarketData;
import org.apache.ibatis.annotations.Mapper;


import java.util.HashMap;

/*
  @type:dao
 *@author wufeiyun
 * time 2020-9-4 15:36
  version 1.0
 * */
@Mapper
public interface MarketDataMapper {
    public void selectMarKetDate(HashMap hashMap);
    public int deleteMarKetDate(MarketData marketData);
    public int updateMarketDate(MarketData marketData);
    public int insertMarketDate(MarketData marketData);
//    按条件查询
    public void selectMarKetDate1(HashMap hashMap);
}
