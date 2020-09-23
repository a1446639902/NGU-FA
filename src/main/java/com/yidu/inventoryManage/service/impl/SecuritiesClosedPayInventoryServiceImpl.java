package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.SecuritiesClosedPayInventoryMapper;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import com.yidu.inventoryManage.service.SecuritiesClosedPayInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
@Service
public class SecuritiesClosedPayInventoryServiceImpl implements SecuritiesClosedPayInventoryService {
    @Resource
    SecuritiesClosedPayInventoryMapper securitiesClosedPayInventoryMapper;
    @Resource
    DbUtil dbUtil;

    /**
     * 查询证券应收应付的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param securitiesType 证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
     * @param dateTime 业务日期
     * @return 返回hashMap对象
     */
    @Override
    public HashMap selectSecuritiesClosedPayInventory(int page, int limit,String securitiesType,String dateTime) {
        StringBuffer stringBuffer = new StringBuffer();
        //判断dateTime是否为空，不为空则添加条件
        if(dateTime!=null && !dateTime.equals("")){
            stringBuffer.append(" and dateTime='"+dateTime+"'");
        }
        //判断securitiesType是否为空不为空则添加查询条件
        String tableName=" (select * from securitiesClosedPayInventory scpi  join securities st on scpi.securitiesId=st.securitiesId ";
        if (securitiesType!=null && !securitiesType.equals("")){
            int i = Integer.parseInt(securitiesType);
            tableName=tableName+" and  scpi.securitiesType="+i;
        }
        tableName=tableName+" )";
        //创建hashMap，调用存储过程,(p_tableName,p_condition,p_pageSize,p_page,p_count,p_cursor)
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


    /**
     * 新增证券应收应付的方法
     * @param securitiesClosedPayInventoryPojo 证券应收应付的实体类
     * @return 返回 1新增成功 0新增失败
     */
    @Override
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo) {
        securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
        return securitiesClosedPayInventoryMapper.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);

    }

    /**
     * 修改证券应收应付的方法
     * @param securitiesClosedPayInventoryPojo 证券应收应付的实体类
     * @return 返回 1修改成功 0修改失败
     */
    @Override
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo) {

        return securitiesClosedPayInventoryMapper.updateSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
    }

    /**
     * 删除证券应收应付的方法
     * @param securitiesClosedPayInventoryIds 证券应收应付Id
     * @return 返回 1删除成功 0删除失败
     */
    @Override
    public int deleteSecuritiesClosedPayInventory(String securitiesClosedPayInventoryIds) {
        //判断securitiesClosedPayInventoryIds是否为空，不为空 进行切割 装入集合
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
