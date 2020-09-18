package com.yidu.reportManage.service;

import java.util.HashMap;

/**
 *author xbf
 * 2020-9-18
 **/
public interface StockEquityInformationServices {
    public HashMap selectStockEquityInformation(int page,int limit,String issueDate);
}
