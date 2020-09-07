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
    public HashMap selectMarKetDate(String marketId,String dateTime,int page,int limit) {
        HashMap marketDataMap = new HashMap();
        marketDataMap.put("p_tableName","(select * from MARKET m  join SECURITIES s on m.SECURITIESID=s.SECURITIESID;)");
        if (marketId!=null&&marketId!=""){
            marketDataMap.put("p_condition","and marketId like '%marketId%' ");
        }else if(dateTime!=null&&dateTime!=""){
            marketDataMap.put("p_condition","and marketId like '%"+marketId+"%' and dateTime="+dateTime);
        }else{
            marketDataMap.put("p_condition","");
        }
        marketDataMap.put("p_pageSize",limit);
        marketDataMap.put("p_page",page);
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
    public HashMap selectMarKetDate1(int page,int limit,String searchMarketId,String searchTime) {
        HashMap marketDataMap = new HashMap();
        marketDataMap.put("p_tableName","(select * from MARKET m  join SECURITIES s on m.SECURITIESID=s.SECURITIESID)");

        if(searchMarketId!=null&&searchMarketId!=""){
            marketDataMap.put("p_condition","and marketId like '%"+searchMarketId+"%'");
        }
        else if (searchTime!=null&&searchTime!=""){
            marketDataMap.put("p_condition"," and marketId like '%" +searchMarketId+"%' and dateTime like '%"+ searchTime+"%'");
        }else {
            marketDataMap.put("p_condition","");
        }


        marketDataMap.put("p_pageSize",limit);
        marketDataMap.put("p_page",page);
        marketDataMap.put("p_count",0);
        marketDataMap.put("p_cursor",null);
        marketDataMapper.selectMarKetDate(marketDataMap);
        return marketDataMap;
    }


}
