package com.yidu.dayDispose.service;

import com.yidu.dayDispose.pojo.InventoryEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 库存统计的service接口
 * @Mr.Zou
 */
public interface InventoryService {


    /**
     * 库存统计service接口
     * @return
     */
    public List<InventoryEntity> selectInventory(HttpServletRequest request, String dateTime3, String invId);

}
