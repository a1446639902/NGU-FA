package com.yidu.businessData.service.impl;


import com.yidu.businessData.mapper.MarketDataMapper;
import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.service.MarketDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
/*
  @type:实现类
 *@author wufeiyun
 * time 2020-9-4 15:36
  version 1.0
 * */
@Service
public class MarketDataServiceImpl implements MarketDataService {
    @Resource
    MarketDataMapper marketDataMapper;

    @Override
    public HashMap selectMarKetDate() {
        HashMap marketDataMap = new HashMap();
        marketDataMap.put("p_tableName","market");
        marketDataMap.put("p_condition","");
        marketDataMap.put("p_pageSize",4);
        marketDataMap.put("p_page",1);
        marketDataMap.put("p_count",0);
        marketDataMap.put("p_cursor",null);
        marketDataMapper.selectMarKetDate(marketDataMap);
        return marketDataMap;
    }

    @Override
    public int deleteMarKetDate(MarketData marketData) {
        return marketDataMapper.deleteMarKetDate(marketData);
    }

    @Override
    public int updateMarketDate(MarketData marketData) {
        return marketDataMapper.updateMarketDate(marketData);
    }

    @Override
    public int insertMarketDate(MarketData marketData) {
        return marketDataMapper.insertMarketDate(marketData);
    }

    @Override
    public HashMap selectMarKetDate1(String marketId,String dateTime) {
        HashMap marketDataMap = new HashMap();
        marketDataMap.put("p_tableName","market");
        if (marketId!=null&&marketId!=""){
            marketDataMap.put("p_condition","and marketId like %marketId%");
        }
        if(dateTime!=null&&dateTime!=""){
            marketDataMap.put("p_condition","and marketId like %marketId% and dateTime=dataTime");
        }

        marketDataMap.put("p_pageSize",4);
        marketDataMap.put("p_page",1);
        marketDataMap.put("p_count",0);
        marketDataMap.put("p_cursor",null);
        marketDataMapper.selectMarKetDate(marketDataMap);
        return marketDataMap;
    }

}
