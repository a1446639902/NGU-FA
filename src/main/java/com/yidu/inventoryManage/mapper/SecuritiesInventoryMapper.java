package com.yidu.inventoryManage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface SecuritiesInventoryMapper {
    public void selectStockofSecurities(HashMap hashMap);
}
