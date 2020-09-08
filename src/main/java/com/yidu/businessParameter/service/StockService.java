package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.pojo.StockPojo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 用户的dao方法
 * date:2020.9.8
 * @author xbf
 * @version 1.0
 */
@Service
public interface StockService {
    public int insertStock(StockPojo stockPojo);
    public int deleteStock(String stockId);
    public int updateStock(StockPojo stockPojo);
    public HashMap selectStock();
}
