package com.yidu.reportManage.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Version:     1.0
 * Datetime:    2020/9/18 14:51
 * Author:   xbf
 */
@Service
public interface StockPriceFluctuationTableService {
    public Map<String,Object> SelectStockPrice(String pageSize, String page, String dateTime );
}
