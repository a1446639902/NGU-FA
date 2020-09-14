package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.pojo.StockPojo;
import com.yidu.businessParameter.service.StockService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股票板块
 * @type 控制层
 * @author xbf
 * @date 2020-09-11
 * @version 1.0
 */
@RestController
@RequestMapping("Stock")
public class StockController {
    @Resource
    StockService stockService;

    //查询
    @RequestMapping("selectStock")
    public Map<String,Object> selectStock() {
        List<SecuritiesPojo> securitiesList = stockService.selectStock();
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",null);
        json.put("data",securitiesList);
        //返回数据
        return json;

    }
    //增加
    @RequestMapping("insertStock")
    public int insertStock(StockPojo stockPojo){
        int i = stockService.insertStock(stockPojo);
        return i;
    }

    @RequestMapping("selectSonStock")
    public Map<String,Object> selectSonStock() {
        List<StockPojo> securitiesList = stockService.selectSonStock();
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",null);
        json.put("data",securitiesList);
        //返回数据
        return json;

    }


     //修改
    @RequestMapping("updateStock")
    public int updateStock(StockPojo stockPojo){
        int i=stockService.updateStock(stockPojo);
        return i;
    }


     //删除
    @RequestMapping("deleteStock")
    public int deleteStock(String stockId ){
        int i = stockService.deleteStock(stockId);
        return i;
    }

     //查询
    @RequestMapping("selectParentStock")
    public Map<String,Object> selectParentStock() {
        List<StockPojo> stockList = stockService.selectParentStock();
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",null);
        json.put("data",stockList);
        //返回数据
        return json;

    }
}

