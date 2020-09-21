package com.yidu.reportManage.controller;

import com.yidu.reportManage.pojo.StockPriceFluctuationTable;
import com.yidu.reportManage.service.StockPriceFluctuationTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Version:     1.0
 * Datetime:    2020/9/18 14:51
 * Author:   xbf
 */
@RestController
@RequestMapping("StockPriceFluctuationTable")
public class StockPriceFluctuationTableController {
    @Resource
    StockPriceFluctuationTableService stockPriceFluctuationTableService;

    @RequestMapping("SelectStockPrice")
    public Map<String,Object> SelectStockPrice(String page,String limit,String dateTimes){
        System.out.println("进入股票价格波动表controller");

        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = stockPriceFluctuationTableService.SelectStockPrice(limit,page,dateTimes);
        System.out.printf(map.toString());
        //从结果集中拿出结果
        List<StockPriceFluctuationTable> stockPriceFluctuationTableList = (List<StockPriceFluctuationTable>) map.get("stockPriceFluctuationTableList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",stockPriceFluctuationTableList);
        //返回数据
        return json;
    }
}
