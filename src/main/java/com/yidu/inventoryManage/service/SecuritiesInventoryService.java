package com.yidu.inventoryManage.service;

import com.yidu.inventoryManage.pojo.SecuritiesInventory;

import java.util.HashMap;
/*
  @type:证券库存dao层
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
public interface SecuritiesInventoryService {
    public HashMap selectSecuritiesInventory(int page,int limit,String sreachTime,String sreachId);
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory);
    public int deleteSecuritiesInventory(int securitiesInventoryId);
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory);

    /**
     * 根据日期删除的service层的接口
     * @param date
     */
    public void deleteDateSecuritiesInventory(String date);

}
