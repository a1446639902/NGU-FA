package com.yidu.inventoryManage.mapper;

import com.yidu.businessData.pojo.EquityData;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
/**
 *@author wzh
 *date 2020-9-21
 * 现金应收应付到库存Mapper接口
 */
@Mapper
public interface CashClosedPaylnventoryMapper {
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
    public int  deleteCashClosedPaylnventory(List cashClosedPayInventoryId);

    /**
     * 现金应收应付到库存修改方法
     * @param cashClosedPayInventory
     * @return
     */
    public int updateCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory);

    /**
     * 现金应收应付到库存查询方法
     * @param map
     */
    public void selectCashClosedPaylnventory(Map map);


    /**
     * 根据日期删除现金应收应付表的信息
     * @param date
     */
    @Delete("delete cashClosedPayInventory where businessDate=#{date}")
    public void delectDateInventory(String date);

}

