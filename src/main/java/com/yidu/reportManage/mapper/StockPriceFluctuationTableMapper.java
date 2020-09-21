package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Version:     1.0
 * Datetime:    2020/9/18 14:51
 * Author:   xbf
 */
@Mapper
public interface StockPriceFluctuationTableMapper {
    void SelectStockPrice(Map map);
}
