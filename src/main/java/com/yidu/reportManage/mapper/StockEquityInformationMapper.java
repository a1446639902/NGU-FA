package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 *author xbf
 * 2020-9-18
 **/
@Mapper
public interface StockEquityInformationMapper {
    public void selectStockEquityInfortmation(HashMap hashMap);
}
