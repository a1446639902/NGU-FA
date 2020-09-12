package com.yidu.dayDispose.controller;

import com.yidu.dayDispose.pojo.InventoryEntity;
import com.yidu.dayDispose.service.InventoryService;
import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 库存统计的控制层
 * @Mr.Zou
 **/
@RestController
public class InventoryController {

    @Resource
    private InventoryService inventoryService;

    /**
     * 库存统计显示在网页的数据
     * @return
     */
    @RequestMapping("/selectInventory")
    public HashMap selectInventory(HttpServletRequest request,String dateTime3,String invId){
        //获得基金id
        String fundId = GetFundIdUtil.getFundId(request);

        List<InventoryEntity> inventoryEntities = inventoryService.selectInventory(dateTime3,invId);
        HashMap userMap = new HashMap();
        userMap.put("count",10);
        userMap.put("code",0);
        userMap.put("msg","");
        userMap.put("data",inventoryEntities);
        return userMap;
    }


}