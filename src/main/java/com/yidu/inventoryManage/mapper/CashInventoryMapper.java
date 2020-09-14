package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.CashInventoryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 现金库存的实体类
 * @Mr.Zou
 * date:2020/9/5
 */
@Mapper
public interface CashInventoryMapper {

    /**
     * 多表关联查询（显示在页面）
     * @return
     */
    public void selectCashInventory(Map map);

    /**
     * 删除
     * @param userId 要删除的ID
     */
    @Delete("delete from cashInventory where cashInventoryId=#{userId}")
    public void deleteCashInventor(String userId);

    /**
     * 根据日期删除的方法
     * @param date
     */
    @Delete("delete CASHINVENTORY where DATETIME=#{date}")
    public void deleteDateInventor(String date);

    /**
     * 新增的mapper
     */
    @Insert("insert into cashInventory values (#{cashInventoryId},#{fundId},#{cashBlance},#{accountId},#{dateTime},#{securitiesNum},#{securityPeriodFlag},#{cashInventoryDesc})")
    public void insertCashInventory(CashInventoryEntity cashInventoryEntity);

    /**
     * 修改的mapper
     * 获得要修改的id  然后通过id修改金额
     */
    @Update("update cashInventory set cashBlance=#{cashBlance},cashInventoryDesc=#{cashInventoryDesc} where cashInventoryId=#{cashInventoryId}")
    public void updateCashInventory(double cashBlance,String cashInventoryDesc,String cashInventoryId);

}
