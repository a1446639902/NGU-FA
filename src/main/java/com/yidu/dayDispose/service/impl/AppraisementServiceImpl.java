package com.yidu.dayDispose.service.impl;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.dayDispose.mapper.AppraisementMapper;
import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.dayDispose.service.AppraisementService;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventory;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
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

    //查交易数据 按证券代码分组 插入证券应收应付库存
    @Override
    public HashMap selectTransactionData() {
        HashMap ransactionDataMap = new HashMap();
        ransactionDataMap.put("p_tableName","(select securitiesId,dateTime,SUM((totalSum*flag)) totalSum from transactionData  where to_date(dateTime,'yyyy-MM-dd') <= to_date('2020-09-02','yyyy-MM-dd') and transactionDataMode in (1,2,3,4) and to_date('2020-09-14','yyyy-MM-dd') < to_date(settlementDate,'yyyy-MM-dd')\n" +
                "\t    GROUP BY securitiesId,dateTime)");
        ransactionDataMap.put("p_condition","");
        ransactionDataMap.put("p_pageSize",5);
        ransactionDataMap.put("p_page",1);
        ransactionDataMap.put("p_count",0);
        ransactionDataMap.put("p_cursor",null);
        appraisementMapper.selectTransactionData(ransactionDataMap);
        return ransactionDataMap;
    }

    @Override
    public int deleteSecuritiesClosedPayInventoryTwo(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo) {
        return appraisementMapper.deleteSecuritiesClosedPayInventoryTwo(securitiesClosedPayInventoryPojo);
    }

    @Override
    public HashMap selectTaTransaction() {
        HashMap taTransactionMap = new HashMap();
        taTransactionMap.put("p_tableName","(select sum(totalMoney) totalMoney,transactionType,accountId,dateTime ,fundId from taTransaction where to_date(dateTime,'yyyy-MM-dd')<= to_date('2020-09-13','yyyy-MM-dd')\n" +
                "and to_date('2020-09-13','yyyy-MM-dd')<to_date(balanceDate,'yyyy-MM-dd') group by transactionType, accountId,fundId,dateTime;)");
        taTransactionMap.put("p_condition","");
        taTransactionMap.put("p_pageSize",5);
        taTransactionMap.put("p_page",1);
        taTransactionMap.put("p_count",0);
        taTransactionMap.put("p_cursor",null);
        appraisementMapper.selectTaTransaction(taTransactionMap);
        return taTransactionMap;
    }
    @Override
    public int deleteCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory){
        return appraisementMapper.deleteCashClosedPaylnventory(cashClosedPayInventory);
    }
}
