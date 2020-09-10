package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.SecuritiesInventoryMapper;
import com.yidu.inventoryManage.pojo.SecuritiesInventory;
import com.yidu.inventoryManage.service.SecuritiesInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
/*
  @type:证券库存实现类
 *@author wufeiyun
 * time 2020-9-7 15:36
  version 1.0
 * */
@Service
public class SecuritiesInventoryServiceImpl implements SecuritiesInventoryService {
    @Resource
    SecuritiesInventoryMapper securitiesInventoryMapper;
    @Resource
    DbUtil dbUtil;

    @Override
    public HashMap selectSecuritiesInventory(int page,int limit,String sreachTime,String sreachId) {
        HashMap securitiesInventoryMap = new HashMap();
        securitiesInventoryMap.put("p_tableName","(select * from securitiesInventory se join fund f on se.fundId=f.fundId\n" +
                "join ACCOUNT a on se.accountId= a.accountId join securities s on se.SECURITIESID=s.SECURITIESID)");
        if(sreachTime!=null&&sreachTime!=""){
            securitiesInventoryMap.put("p_condition"," and dateTime like '%"+sreachTime+"%'");
        }
        else if (sreachId!=null&&sreachId!=""){
            securitiesInventoryMap.put("p_condition"," and securitiesInventoryId like '%" +sreachId+"%' and dateTime like '%"+ sreachTime+"%'");
        }else {
            securitiesInventoryMap.put("p_condition","");
        }
        securitiesInventoryMap.put("p_pageSize",limit);
        securitiesInventoryMap.put("p_page",page);
        securitiesInventoryMap.put("p_count",0);
        securitiesInventoryMap.put("p_cursor",null);
        securitiesInventoryMapper.selectSecuritiesInventory(securitiesInventoryMap);
        return securitiesInventoryMap;
    }

    @Override
    public int updateSecuritiesInventory(SecuritiesInventory securitiesInventory) {
        int i = securitiesInventoryMapper.updateSecuritiesInventory(securitiesInventory);
        return i;
    }

    @Override
    public int deleteSecuritiesInventory(int securitiesInventoryId) {
        int i = securitiesInventoryMapper.deleteSecuritiesInventory(securitiesInventoryId);
        return i;
    }
    public int insertSecuritiesInventory(SecuritiesInventory securitiesInventory){
        securitiesInventory.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.M));
        int i = securitiesInventoryMapper.insertSecuritiesInventory(securitiesInventory);
        return i;
    }
}
