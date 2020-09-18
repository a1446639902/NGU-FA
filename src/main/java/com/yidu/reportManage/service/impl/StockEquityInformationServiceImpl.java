package com.yidu.reportManage.service.impl;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.reportManage.mapper.StockEquityInformationMapper;
import com.yidu.reportManage.pojo.StockEquityInformationPojo;
import com.yidu.reportManage.service.StockEquityInformationServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 *author xbf
 * 2020-9-18
 **/
@Service
public class StockEquityInformationServiceImpl implements StockEquityInformationServices {
@Resource
    StockEquityInformationMapper stockEquityInformationMapper;
    @Override
    public HashMap selectStockEquityInformation(int page, int limit, String issueDate) {
        HashMap seiMap = new HashMap();
        String tableName="(select * from securities left join stock on securities.stockId=stock.stockId)";
        seiMap.put("p_tableName",tableName);
        seiMap.put("p_condition","");
        seiMap.put("p_pageSize",limit);
        seiMap.put("p_page",page);
        seiMap.put("p_count",0);
        seiMap.put("p_cursor",null);
        stockEquityInformationMapper.selectStockEquityInfortmation(seiMap);
        return seiMap;
    }
}
