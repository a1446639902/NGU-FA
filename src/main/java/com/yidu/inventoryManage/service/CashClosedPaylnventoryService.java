package com.yidu.inventoryManage.service;

import com.yidu.inventoryManage.pojo.CashClosedPayInventory;

import java.util.List;
import java.util.Map;

public interface CashClosedPaylnventoryService {
    public int insertCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
    public int  deleteCashClosedPaylnventory(String cashClosedPayInventoryId);
    public int updateCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
    public Map<String,Object> selectCashClosedPaylnventory(String pageSize, String page ,String businessType , String businessDate);
}
