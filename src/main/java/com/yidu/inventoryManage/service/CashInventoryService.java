package com.yidu.inventoryManage.service;

import com.yidu.inventoryManage.pojo.CashInventoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 现金库存的service层
 * @Mr.Zou
 * date：2020/9/5
 */
public interface CashInventoryService {

    /**
     * 多表关联查询（显示在页面）
     * @return
     */
    public Map<String, Object> selectCashInventory(String pageSize, String page,String accountId,String dateTime);



    /**
     * 删除
     * @param userId
     */
    public void deleteCashInventor(String userId);

    /**
     * 新增的service
     */
    public void insertCashInventory(CashInventoryEntity cashInventoryEntity);

    /**
     * 批量删除的方法
     * @param cashInventoryId
     */
    public void deleteMoreCashInventory(String cashInventoryId);

    /**
     * 修改的方法
     * @param cashInventoryEntity
     */
    public void updateCashInventory(CashInventoryEntity cashInventoryEntity);

}
