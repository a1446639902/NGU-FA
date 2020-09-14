package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.AppraisementMapper;
import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.dayDispose.service.AppraisementService;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


@Service
public class AppraisementServiceImpl implements AppraisementService {
    @Resource
    AppraisementMapper appraisementMapper;
    // 查询是否处理的实现类
    @Override
    public List<Appraisement> selectValuationProcessing() {
        return appraisementMapper.selectValuationProcessing();
    }

    @Override
    public HashMap selectStockarket() {
        HashMap stockarketMap = new HashMap();
        stockarketMap.put("p_tableName","(select se.fundId,se.securitiesId,  ROUND((SE.securitiesNum*M.closingPrice ),2)as tootaIPrice, SE.securityPeriodFlag from securitiesInventory se join market m on se.securitiesId=m.securitiesId)");
        stockarketMap.put("p_condition","");
        stockarketMap.put("p_pageSize",10);
        stockarketMap.put("p_page",1);
        stockarketMap.put("p_count",0);
        stockarketMap.put("p_cursor",null);
        appraisementMapper.selectStockarket(stockarketMap);
        return stockarketMap;
    }

    @Override
    public int deleteSecuritiesClosedPayInventory(SecuritiesClosedPayInventory securitiesClosedPayInventory) {
        return appraisementMapper.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventory);
    }
}
