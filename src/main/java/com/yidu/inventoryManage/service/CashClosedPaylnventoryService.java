package com.yidu.inventoryManage.service;

import com.yidu.inventoryManage.pojo.CashClosedPayInventory;

import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-22
 * 现金应收应付到库存服务器Service
 */
public interface CashClosedPaylnventoryService {
    /**
     * 现金应收应付到库存新增方法
     * @param cashClosedPayInventory
     * @return
     */
    public int insertCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);
    /**
     * 现金应收应付到库存删除方法
     * @param cashClosedPayInventoryId
     * @return
     */
    public int  deleteCashClosedPaylnventory(String cashClosedPayInventoryId);
    /**
     * 现金应收应付到库存修改方法
     * @param cashClosedPayInventory
     * @return
     */
    public int updateCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);

    /**
     * 现金应收应付到库存查询方法
     * @param pageSize
     * @param page
     * @param businessType
     * @param businessDate
     * @return
     */
    public Map<String,Object> selectCashClosedPaylnventory(String pageSize, String page ,String businessType , String businessDate);
}
