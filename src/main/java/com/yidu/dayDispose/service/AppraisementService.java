package com.yidu.dayDispose.service;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.dayDispose.pojo.ValuationProcessing;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;

import java.util.HashMap;
import java.util.List;

public interface AppraisementService {
    //查询表格内容
    public List<ValuationProcessing> selectBiaoge();

    //查询应收应付状态
    public List<Appraisement> selectValuationProcessing();
    //证券库存join行情表查询
    public HashMap selectStockarket(String toDay);
    //删除证券应收应付库存
    public int deleteSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);

    //查交易数据 按证券代码分组 插入证券应收应付库存
    public HashMap selectTransactionData();
    //查交易数据后 按条件删除 证券应收应付表的内容
    public int deleteSecuritiesClosedPayInventoryTwo(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);

    //查询ta交易数据
    public HashMap selectTaTransaction();

    //删除现金应收应付
    public int deleteCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
}
