package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.SecuritiesClosedPayInventoryMapper;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import com.yidu.inventoryManage.service.SecuritiesClosedPayInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 证券应收应付库存
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层的实现类
 * @time 2020/9/13
 **/
@Service
public class SecuritiesClosedPayInventoryServiceImpl implements SecuritiesClosedPayInventoryService {
    @Resource
    SecuritiesClosedPayInventoryMapper securitiesClosedPayInventoryMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectSecuritiesClosedPayInventory(int page, int limit,String securitiesType,String dateTime) {
        StringBuffer stringBuffer = new StringBuffer();
        if(dateTime!=null && !dateTime.equals("")){
            stringBuffer.append(" and dateTime='"+dateTime+"'");
        }
        String tableName=" (select * from securitiesClosedPayInventory scpi  join securities st on scpi.securitiesId=st.securitiesId ";
        if (securitiesType!=null && !securitiesType.equals("")){
            int i = Integer.parseInt(securitiesType);
            tableName=tableName+" and  scpi.securitiesType="+i;
        }
        tableName=tableName+" )";

        HashMap scpiMap = new HashMap<>();
        scpiMap.put("p_tableName",tableName);
        scpiMap.put("p_condition",stringBuffer.toString());
        scpiMap.put("p_pageSize",limit);
        scpiMap.put("p_page",page);
        scpiMap.put("p_count",0);
        scpiMap.put("p_cursor",null);
        securitiesClosedPayInventoryMapper.selectSecuritiesClosedPayInventory(scpiMap);
        return scpiMap;
    }

    @Override
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo) {
        securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
        return securitiesClosedPayInventoryMapper.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);

    }

    @Override
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo) {

        return securitiesClosedPayInventoryMapper.updateSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
    }

    @Override
    public int deleteSecuritiesClosedPayInventory(String securitiesClosedPayInventoryIds) {
        if (securitiesClosedPayInventoryIds != null && !securitiesClosedPayInventoryIds.equals("")) {
            String[] split = securitiesClosedPayInventoryIds.split(",");
            ArrayList securitiesClosedPayInventoryIdList = new ArrayList<>();
            for (String securitiesClosedPayInventoryId : split) {
                securitiesClosedPayInventoryIdList.add(securitiesClosedPayInventoryId);
            }
            return securitiesClosedPayInventoryMapper.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventoryIdList);
        }
        return 0;
    }

}
