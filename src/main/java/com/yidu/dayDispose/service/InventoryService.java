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
     * 显示在网页的库存状态信息
     * @return
     */
    public List<InventoryEntity> selectInventory(HttpServletRequest request, String dateTime3, String invId);

}
