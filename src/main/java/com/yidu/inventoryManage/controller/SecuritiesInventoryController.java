package com.yidu.inventoryManage.controller;

import com.yidu.inventoryManage.pojo.SecuritiesInventory;
import com.yidu.inventoryManage.service.SecuritiesInventoryService;
import com.yidu.permission.aspect.NGULog;
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
    @NGULog(message = "增加证券库存")
    @RequestMapping("selectSecuritiesInventory")
    //page 页码  limit 每页的条数  String sreachTime,String sreachId 查询的条件
    public HashMap selectSecuritiesInventory(int page, int limit,String sreachTime,String sreachId){
        HashMap hashMap = securitiesInventoryService.selectSecuritiesInventory(page, limit,sreachTime,sreachId);
        System.out.println(sreachId+" "+sreachTime);
        //通过(int)hashMap.get("p_count")获得count条数
        int count = (int)hashMap.get("p_count");
        //通过(List<SecuritiesInventory>)hashMap.get("p_cursor")获得SecuritiesInventory 类型的集合
        List<SecuritiesInventory> securitiesInventoryList = (List<SecuritiesInventory>)hashMap.get("p_cursor");
        HashMap securitiesInventoryMap = new HashMap();
        securitiesInventoryMap.put("code",0);
        securitiesInventoryMap.put("count",count);
        securitiesInventoryMap.put("msg","");
        securitiesInventoryMap.put("data",securitiesInventoryList);
        return securitiesInventoryMap;
    }
    @NGULog(message = "修改证券库存")
    @RequestMapping("updateSecuritiesInventory")
    //传入SecuritiesInventory 类型的实体类进行修改
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory){
        System.out.println(securitiesInventory);
        int i = securitiesInventoryService.updateSecuritiesInventory(securitiesInventory);
        return i;
    }

    @NGULog(message = "删除证券库存")
    @RequestMapping("deleteSecuritiesInventory")
    //前端返回securitiesInventorys字符串
    public int deleteSecuritiesInventory(String securitiesInventorys){
        int i=0;
        System.out.println("进来了");
        System.out.println(securitiesInventorys);
        //切割字符串
        String[] split = securitiesInventorys.split(",");
        for (String s : split) {
            System.out.println(s);
            i = securitiesInventoryService.deleteSecuritiesInventory(s);
        }
//
        return i;
    }
    @NGULog(message = "增加证券库存")
    @RequestMapping("InsertSecuritiesInventory")
    //参数为SecuritiesInventory实体类,前端传SecuritiesInventory实体类
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory){

        securitiesInventory.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SI));
        System.out.println(securitiesInventory.getSecuritiesInventoryId());
        System.out.println(securitiesInventory+"这是插入证券库存的id===================");
        int i = securitiesInventoryService.insertSecuritiesInventory(securitiesInventory);
        return i;
    }
}
