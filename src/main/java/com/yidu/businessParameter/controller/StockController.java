package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.StockPojo;
import com.yidu.businessParameter.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 股票板块的控制类
 * date:2020.9.8
 * @author xbf
 * @version 1.0
 */
@RestController
public class StockController {
    @Resource
    StockService stockService;

    //添加
    @RequestMapping("/insertStock")
    public int insertStock(StockPojo stockPojo){
        return stockService.insertStock(stockPojo);
    }

    //删除
    @RequestMapping("/deleteStock")
    public int deleteStock(String stockId){
        return stockService.deleteStock(stockId);
    }

    //修改
    @RequestMapping("/updateStock")
    public int updateStock(StockPojo stockPojo){
        return stockService.updateStock(stockPojo);
    }

    //查询
    @RequestMapping("/selectStock")
    public HashMap selectStock(){
        HashMap hashMap=stockService.selectStock();
        int count= (int) hashMap.get("p_count");
        List<StockPojo>stockPojoList= (List<StockPojo>) hashMap.get("p_cursor");
        HashMap stockMap=new HashMap();
        stockMap.put("count",count);
        stockMap.put("code",0);
        stockMap.put("msg","");
        stockMap.put("data",stockPojoList);
        return stockMap;
    }

}
