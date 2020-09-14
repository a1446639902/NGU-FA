package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/13
 **/
@Mapper
public interface SecuritiesClosedPayInventoryMapper {
    public HashMap selectSecuritiesClosedPayInventory(HashMap hashMap);
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int deleteSecuritiesClosedPayInventory(List securitiesClosedPayInventoryIdList);
}
