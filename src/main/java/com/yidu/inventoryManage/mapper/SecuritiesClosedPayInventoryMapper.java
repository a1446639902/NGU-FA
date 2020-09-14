package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 证券应收应付库存
 * @author 黄志豪
 * @version 1.0
 * @Type dao层
 * @time 2020/9/13
 **/
@Mapper
public interface SecuritiesClosedPayInventoryMapper {
    public HashMap selectSecuritiesClosedPayInventory(HashMap hashMap);
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int deleteSecuritiesClosedPayInventory(List securitiesClosedPayInventoryIdList);
}
