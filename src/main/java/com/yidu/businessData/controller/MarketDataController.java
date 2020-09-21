package com.yidu.businessData.controller;


import com.yidu.permission.aspect.NGULog;
import com.yidu.util.marketDateUtil;
import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.service.MarketDataService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  @type:行情数据控制层
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
@Component
@RestController
@RequestMapping("/MarketData")
public class MarketDataController {
    @Resource
    MarketDataService marketDataService;

    @Resource
    DbUtil dbUtil;
    @NGULog(message = "删除行情数据")
   @RequestMapping("/deleteMarKetDate")
    public int deleteMarKetDate(String marketIds){
        int i=0;
       System.out.println(marketIds);
       String[] split = marketIds.split(",");
       for (String s : split) {
           MarketData marketData = new MarketData();
           marketData.setMarketId(s);
           i = marketDataService.deleteMarKetDate(marketData);
       }
       return i;
   }
    @NGULog(message = "修改行情数据")
    @RequestMapping("/updateMarKetDate")
    public int updateMarKetDate(MarketData marketData){
        System.out.println(marketData);
        int i = marketDataService.updateMarketDate(marketData);
        System.out.println(i);
        return i;
    }
    @NGULog(message = "增加行情数据")
    @RequestMapping("/insertMarKetDate")
    public int insertMarKetDate(MarketData marketData){
        System.out.println("增加进来了===========================");
        System.out.println(marketData);
        marketData.setMarketId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.M));
        System.out.println(marketData);
        return marketDataService.insertMarketDate(marketData);
    }
    @NGULog(message = "查询行情数据")
    @RequestMapping("/selectMarKetDate")
    public HashMap selectMarKetDate(int page,int limit,String searchMarketId,String searchTime){
        System.out.println("进来了====================================================");
        System.out.println(searchMarketId+","+searchTime);
        HashMap hashMap = marketDataService.selectMarKetDate1(page, limit,searchMarketId,searchTime);
        int count = (int)hashMap.get("p_count");
        List<MarketData> marketDataList = (List<MarketData>)hashMap.get("p_cursor");
        System.out.println(marketDataList);
        HashMap stockofSecuritiesMap = new HashMap();
        stockofSecuritiesMap.put("code",0);
        stockofSecuritiesMap.put("count",count);
        stockofSecuritiesMap.put("msg","");
        stockofSecuritiesMap.put("data",marketDataList);
        return stockofSecuritiesMap;
    }

    @NGULog(message = "行情数据导入")
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadMarket(MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        List<MarketData> list1 = marketDateUtil.getList(MarketData.class,file.getInputStream(),0);
        for (MarketData marketData : list1) {
            System.out.println(marketData);
            int i = marketDataService.insertMarketDate(marketData);
            System.out.println(i);
        }
        return map;

    }

}
