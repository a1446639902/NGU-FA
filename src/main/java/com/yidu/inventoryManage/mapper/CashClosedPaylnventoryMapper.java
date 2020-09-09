package com.yidu.inventoryManage.mapper;

import com.yidu.businessData.pojo.EquityData;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface CashClosedPaylnventoryMapper {
    public int insertCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
    public int  deleteCashClosedPaylnventory(List cashClosedPayInventoryId);
    public int updateCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
    public void selectCashClosedPaylnventory(Map map);
}

