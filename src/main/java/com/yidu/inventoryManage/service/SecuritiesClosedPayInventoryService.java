package com.yidu.inventoryManage.service;

import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;

import java.util.HashMap;
import java.util.List;

/**
 * 证券应收应付库存
 * @author 戴言露
 * @version 1.0
 * @Type 服务层
 * @time 2020/9/13
 **/
public interface SecuritiesClosedPayInventoryService {
    public HashMap selectSecuritiesClosedPayInventory(int page,int limit,String securitiesType,String dateTime);
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int deleteSecuritiesClosedPayInventory(String securitiesClosedPayInventoryIds);
}
