package com.yidu.dayDispose.service;

import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventory;

import java.util.HashMap;
import java.util.List;

public interface AppraisementService {
    //查询应收应付状态
    public List<Appraisement> selectValuationProcessing();
    //证券库存join行情表查询
    public HashMap selectStockarket();
    //删除证券应收应付库存
    public int deleteSecuritiesClosedPayInventory(SecuritiesClosedPayInventory securitiesClosedPayInventory);

}
