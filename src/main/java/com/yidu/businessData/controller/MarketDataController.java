package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.service.MarketDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
/*
  @type:控制层
 *@author wufeiyun
 * time 2020-9-2 15:36
  version 1.0
 * */
@RestController
@RequestMapping("/MarketData")
public class MarketDataController {
    @Resource
    MarketDataService marketDataService;

    @RequestMapping("/selectMarKetDate")
    public HashMap selectTaTransaction(){
        HashMap hashMap = marketDataService.selectMarKetDate();
        int count = (int)hashMap.get("p_count");
        List<MarketData> marketDataList = (List<MarketData>)hashMap.get("p_cursor");
        HashMap stockofSecuritiesMap = new HashMap();
        stockofSecuritiesMap.put("code",0);
        stockofSecuritiesMap.put("count",count);
        stockofSecuritiesMap.put("msg","");
        stockofSecuritiesMap.put("data",marketDataList);
        return stockofSecuritiesMap;
    }
   @RequestMapping("/deleteMarKetDate")
    public int deleteMarKetDate(String marketId){
       System.out.println(marketId);
        MarketData marketData = new MarketData();
        marketData.setMarketId(marketId);
       int i = marketDataService.deleteMarKetDate(marketData);
       System.out.println(i);
       return i;
   }
    @RequestMapping("/updateMarKetDate")
    public int updateMarKetDate(){

        MarketData marketData = new MarketData();
        marketData.setMarketId("1213");
        marketData.setMarketDesc("投资有风险");
        marketData.setClosingPrice(12.1);
        marketData.setOpenPrice(12.4);
        marketData.setDateTime("1999-9-8");
        marketData.setSecuritiesName("步方证券");
        int i = marketDataService.updateMarketDate(marketData);
        System.out.println(i);
        return i;
    }
    @RequestMapping("/insertMarKetDate")
    public int insertMarKetDate(MarketData Data){
//        MarketData marketData = new MarketData();
//        marketData.setMarketId("12132222");
//        marketData.setMarketDesc("投资有风险");
//        marketData.setClosingPrice(12.1);
//        marketData.setOpenPrice(12.4);
//        marketData.setDateTime("1999-9-8");
//        marketData.setSecuritiesName("步方证券");
        int i = marketDataService.insertMarketDate(Data);
        System.out.println(i);
        return i;
    }

}
