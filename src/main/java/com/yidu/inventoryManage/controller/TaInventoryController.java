package com.yidu.inventoryManage.controller;

import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import com.yidu.inventoryManage.service.TaInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Ta库存的控制层
 * @Mr.Zou
 * date：2020/9/2
 */
@RestController
public class TaInventoryController {

    @Resource
    private TaInventoryService taInventoryService;

    /**
     * 查询taInventory（Ta库存）表的控制方法
     * @return
     */
    @RequestMapping("/selectTaInventory")
    public HashMap selectTaInventory(String datetime){

        System.out.println(datetime);

        List<TaInventoryEntity> taInventoryEntity = taInventoryService.selectTaInventory();
        HashMap userMap = new HashMap();
        userMap.put("count",10);
        userMap.put("code",0);
        userMap.put("msg","");
        userMap.put("data",taInventoryEntity);
        return userMap;
    }

    /**
     * 删除taInventory（Ta库存）表的控制方法
     */
    @RequestMapping("/deleteTaInventory")
    public void deleteTaInventory(String userId){
        taInventoryService.deleteTaInventory(userId);
    }

    /**
     * 批量删除taInventory（Ta库存）表的控制方法
     */
    @RequestMapping("/deleteMoreTaInventory")
    public void deleteMoreTaInventory(String taInventoryId){
        taInventoryService.deleteMoreTaInventory(taInventoryId);
    }

    /**
     * 修改taInventory（Ta库存）表的控制方法
     */
    @RequestMapping("/updateTaInventory")
    public void updateTaInventory(TaInventoryEntity taInventoryEntity){
        System.out.println(taInventoryEntity);

//        获得网页用户提交的TAid,TA数量和TA金额
        double tanum = taInventoryEntity.getTanum();
        double tatotal = taInventoryEntity.getTatotal();
        String taInventoryId = taInventoryEntity.getTaInventoryId();
        taInventoryService.updateTaInventory(tanum,tatotal,taInventoryId);

    }

    /**
     * 新增aInventory（Ta库存）表的控制方法
     */
    @RequestMapping("/insertTaInventory")
    public void insertTaInventory(TaInventoryEntity taInventoryEntity){

        System.out.println("我是新增方法"+taInventoryEntity);
        taInventoryService.insertTaInventory(taInventoryEntity);
    }


}
