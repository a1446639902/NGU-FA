package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.SecuritiesInventory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
/*
  @type:证券库存mapper层
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
@Mapper
public interface SecuritiesInventoryMapper {
    public void selectSecuritiesInventory(HashMap hashMap);
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory);
    public int deleteSecuritiesInventory(String securitiesInventoryId);
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory);

    /**
     * 根据日期删除
     * @param date
     */
    @Delete("delete securitiesInventory where datetime=#{date} and SECURITIESID=#{serId}")
    public void deleteDateSecuritiesInventory(String date,String serId);

}
