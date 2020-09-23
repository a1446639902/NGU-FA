package com.yidu.inventoryManage.controller;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import com.yidu.inventoryManage.service.SecuritiesClosedPayInventoryService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 证券应收应付库存
 * @author 黄志豪
 * @version 1.0
 * @Type 控制层
 * @time 2020/9/13
 **/
@RestController
public class SecuritiesClosedPayInventoryController {
    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;

    @NGULog(message="查询证券应收应付库存")
    @RequestMapping("/selectSecuritiesClosedPayInventory")
    public HashMap selectSecuritiesClosedPayInventory(int page,int limit,String securitiesType,String dateTime){
        System.out.println("查询===============");
        System.out.println("dateTime="+dateTime);
        System.out.println("securitiesType="+securitiesType);
        HashMap scpiMap = securitiesClosedPayInventoryService.selectSecuritiesClosedPayInventory(page, limit,securitiesType,dateTime);
        int count = (int) scpiMap.get("p_count");
        ArrayList<SecuritiesClosedPayInventoryPojo> securitiesClosedPayList = (ArrayList<SecuritiesClosedPayInventoryPojo>) scpiMap.get("p_cursor");
        System.out.println(securitiesClosedPayList);
        HashMap hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesClosedPayList);
        return hashMap;
    }

    @NGULog(message="新增证券应收应付库存")
    @RequestMapping("/insertSecuritiesClosedPayInventory")
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo, HttpServletRequest request){
        String fundId = GetFundIdUtil.getFundId(request);
        securitiesClosedPayInventoryPojo.setFundId(fundId);
        System.out.println("xinzeng===============");
        System.out.println(securitiesClosedPayInventoryPojo);
        return securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
    }

    @NGULog(message="修改证券应收应付库存")
    @RequestMapping("/updateSecuritiesClosedPayInventory")
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo){
        System.out.println("修改=========");
        System.out.println(securitiesClosedPayInventoryPojo);
        return securitiesClosedPayInventoryService.updateSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
    }

    @NGULog(message="删除证券应收应付库存")
    @RequestMapping("/deleteSecuritiesClosedPayInventory")
    public int deleteSecuritiesClosedPayInventory(String securitiesClosedPayInventoryIds){
        System.out.println(securitiesClosedPayInventoryIds);
        return securitiesClosedPayInventoryService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventoryIds);
    }
}
