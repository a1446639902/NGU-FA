package com.yidu.dayDispose.mapper;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.dayDispose.pojo.ValuationProcessing;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;

import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
@Mapper
public interface AppraisementMapper {
    //查询应收应付状态
    public List<Appraisement> selectValuationProcessing();
    //证券库存关联行情表查询
    public void selectStockarket(HashMap hashMap);
    //删除证券应收应付库存的方法
    public int deleteSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    //查交易数据 按证券代码分组 插入证券应收应付库存
    public void selectTransactionData(HashMap hashMap);
    //查交易数据后 按条件删除 证券应收应付表的内容
    public int deleteSecuritiesClosedPayInventoryTwo(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    //查询ta交易数据 按账户分组

    public void selectTaTransaction(HashMap hashMap);

    //按条件删除应收应付库存

    public int deleteCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
}
