package com.yidu.inventoryManage.controller;

import com.yidu.businessData.pojo.EquityData;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import com.yidu.inventoryManage.service.CashClosedPaylnventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class CashClosedPaylnventoryController {
    @Resource
    CashClosedPaylnventoryService cashClosedPaylnventoryService;
    @Resource
    DbUtil dbUtil;
    @RequestMapping("insertCashClosedPaylnventory")
    public int insertCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory) {
        cashClosedPayInventory.setCashClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCPI));
        cashClosedPayInventory.setFundId("289289289");
        int i = cashClosedPaylnventoryService.insertCashClosedPaylnventory(cashClosedPayInventory);
        return i;
    }

    @RequestMapping("deleteCashClosedPaylnventory")
    public int deleteCashClosedPaylnventory(String cashClosedPayInventoryId) {
        int i =cashClosedPaylnventoryService.deleteCashClosedPaylnventory(cashClosedPayInventoryId);
        return i;
    }

    @RequestMapping("updateCashClosedPaylnventory")
    public int updateCashClosedPaylnventory(CashClosedPayInventory cashClosedPayInventory) {
        System.out.println(cashClosedPayInventory);
        int i = cashClosedPaylnventoryService.updateCashClosedPaylnventory(cashClosedPayInventory);
        return i;
    }

    @RequestMapping("selectCashClosedPaylnventory")
    public Map<String, Object> selectCashClosedPaylnventory(String page, String limit, String businessType, String businessDate) {
        System.out.println(businessType);
        System.out.println(businessDate);
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =cashClosedPaylnventoryService.selectCashClosedPaylnventory(limit, page, businessType, businessDate);
        List<EquityData> equityDataList = (List<EquityData>) map.get("equityDataList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> cashClosedPayInventoryMap = new HashMap<>();
        cashClosedPayInventoryMap.put("code", 0);
        cashClosedPayInventoryMap.put("msg", "");
        cashClosedPayInventoryMap.put("count", count);
        cashClosedPayInventoryMap.put("data", equityDataList);
        //返回数据
        return cashClosedPayInventoryMap;
    }
}
