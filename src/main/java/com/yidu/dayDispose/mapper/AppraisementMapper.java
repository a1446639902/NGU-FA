package com.yidu.dayDispose.mapper;

import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.dayDispose.pojo.ValuationProcessing;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventory;
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
    public int deleteSecuritiesClosedPayInventory(SecuritiesClosedPayInventory securitiesClosedPayInventory);
}
