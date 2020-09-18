package com.yidu.inventoryManage.controller;

import com.yidu.inventoryManage.pojo.SecuritiesInventory;
import com.yidu.inventoryManage.service.SecuritiesInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
/*
  @type:证券库存控制层
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
@RestController
@RequestMapping("SecuritiesInventory")
public class SecuritiesInventoryController {
    @Resource
    SecuritiesInventoryService securitiesInventoryService;

    @Resource
    DbUtil dbUtil;
    @RequestMapping("selectSecuritiesInventory")
    public HashMap selectSecuritiesInventory(int page, int limit,String sreachTime,String sreachId){
        HashMap hashMap = securitiesInventoryService.selectSecuritiesInventory(page, limit,sreachTime,sreachId);
        System.out.println(sreachId+" "+sreachTime);
        int count = (int)hashMap.get("p_count");
        List<SecuritiesInventory> securitiesInventoryList = (List<SecuritiesInventory>)hashMap.get("p_cursor");
        HashMap securitiesInventoryMap = new HashMap();
        securitiesInventoryMap.put("code",0);
        securitiesInventoryMap.put("count",count);
        securitiesInventoryMap.put("msg","");
        securitiesInventoryMap.put("data",securitiesInventoryList);
        return securitiesInventoryMap;
    }
    @RequestMapping("updateSecuritiesInventory")
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory){
        System.out.println(securitiesInventory);
        int i = securitiesInventoryService.updateSecuritiesInventory(securitiesInventory);
        return i;
    }
    @RequestMapping("deleteSecuritiesInventory")
    public int deleteSecuritiesInventory(String securitiesInventorys){
        int i=0;
        System.out.println("进来了");
        System.out.println(securitiesInventorys);
        String[] split = securitiesInventorys.split(",");
        for (String s : split) {
            System.out.println(s);
            i = securitiesInventoryService.deleteSecuritiesInventory(s);
        }
//
        return i;
    }
    @RequestMapping("InsertSecuritiesInventory")
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory){

        securitiesInventory.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SI));
        System.out.println(securitiesInventory.getSecuritiesInventoryId());
        System.out.println(securitiesInventory+"这是插入证券库存的id===================");
        int i = securitiesInventoryService.insertSecuritiesInventory(securitiesInventory);
        return i;
    }
}
