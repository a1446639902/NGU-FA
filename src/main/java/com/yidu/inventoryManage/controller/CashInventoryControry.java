package com.yidu.inventoryManage.controller;

import com.yidu.inventoryManage.pojo.CashInventoryEntity;
import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import com.yidu.inventoryManage.service.CashInventoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 现金库存的控制层
 * @Mr.Zou
 */
@RestController
public class CashInventoryControry {

    @Resource
    private CashInventoryService cashInventoryService;

    /**
     * 新增CashInventory（现金库存）表的控制方法
     */
    @RequestMapping("/insertCashInventory")
    public void insertCashInventory(CashInventoryEntity cashInventoryEntity){

        System.out.println("我是控制层的新增，我获得的数据为："+cashInventoryEntity);
        cashInventoryService.insertCashInventory(cashInventoryEntity);
    }

    /**
     * 删除CashInventory（现金库存）表的控制方法
     */
    @RequestMapping("/deleteCashInventory")
    public void deleteCashInventory(String userId){
        System.out.println("我从网页获得的数据为："+userId);
        cashInventoryService.deleteCashInventor(userId);
    }

    /**
     * 查询，发送数据至页面显示
     * @param
     * @return
     */
    @RequestMapping("/selectCashInventory")
    public Map<String,Object> selectCashInventory(String page, String limit,String accountName1, String dateTime3){

        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =  cashInventoryService.selectCashInventory(limit,page,accountName1,dateTime3);


        System.out.println("我是控制层账户名为："+accountName1+"日期为："+dateTime3);

        //从结果集中拿出结果
        List<CashInventoryEntity> cashInventoryList = (List<CashInventoryEntity>) map.get("cashInventoryEntity");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",cashInventoryList);
        System.out.println("我是控制层，我传去网页的值为："+cashInventoryList);
        //返回数据
        return json;
    }

    /**
     * 批量删除的方法
     * @param cashInventoryId
     */
    @RequestMapping("/deleteMoreCashInventory")
    public void deleteMoreCashInventory(String cashInventoryId){

        cashInventoryService.deleteMoreCashInventory(cashInventoryId);

    }

    /**
     * 修改的方法
     */
    @RequestMapping("/updateCashInventory")
    public void updateCashInventory(CashInventoryEntity cashInventoryEntity){
        System.out.println("我是修改的方法，我获得的数据为："+cashInventoryEntity);
        cashInventoryService.updateCashInventory(cashInventoryEntity);

    }

}
