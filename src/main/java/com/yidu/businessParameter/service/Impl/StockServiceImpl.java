package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.StockMapper;
import com.yidu.businessParameter.pojo.StockPojo;
import com.yidu.businessParameter.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用户的dao方法
 * date:2020.9.8
 * @author xbf
 * @version 1.0
 */
@Service
@Transactional
public class StockServiceImpl implements StockService {
@Resource
    StockMapper stockMapper;
    @Override
    public int insertStock(StockPojo stockPojo) {
        return stockMapper.insertStock(stockPojo);
    }

    @Override
    public int deleteStock(String stockId) {
        String[] split =stockId.split(",");
        List<String>stockList=new ArrayList<String>();
        for (String id:split) {
            stockList.add(id);
        }
        return stockMapper.deleteStock(stockList);
    }

    @Override
    public int updateStock(StockPojo stockPojo) {
        return stockMapper.updateStock(stockPojo);
    }

    @Override
    public HashMap selectStock() {
        HashMap stockMap = new HashMap();
        stockMap.put("p_tableName","stock");
        stockMap.put("p_condition","");
        stockMap.put("p_pageSize",10);
        stockMap.put("p_page",1);
        stockMap.put("p_count",0);
        stockMap.put("p_cursor",null);
        stockMapper.selectStock(stockMap);
        return stockMap;
    }
}
