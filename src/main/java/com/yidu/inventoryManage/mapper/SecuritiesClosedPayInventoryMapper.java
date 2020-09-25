package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.SeInventoryPayEntity;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 证券应收应付库存
 * @author 戴言露
 * @version 1.0
 * @Type dao层
 * @time 2020/9/13
 **/
@Mapper
public interface SecuritiesClosedPayInventoryMapper {
    public HashMap selectSecuritiesClosedPayInventory(HashMap hashMap);
    public int insertSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int updateSecuritiesClosedPayInventory(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);
    public int deleteSecuritiesClosedPayInventory(List securitiesClosedPayInventoryIdList);

    /**
     * 证券应收应付的实体类
     * @param securitiesClosedPayInventoryPojo
     */
    @Insert("insert into securitiesClosedPayInventory values (#{securitiesClosedPayInventoryId}," +
            "#{dateTime},#{fundId},#{securitiesId},#{securitiesType},#{flag},#{totalPrice},#{securitiesClosedPayDesc},#{securityPeriodFlag})")
    public void insertTaInventoryPayMapper(SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo);


    /**
     * 根据日期,基金信息表Id ,证券信息表ID删除的方法
     * @param date
     */
    @Delete("delete securitiesClosedPayInventory where dateTime=#{date} and FUNDID=#{funId} and SECURITIESID=#{SECURITIESID}")
    public void delectDateTaInventoryPayMapper(String date,String funId,String SECURITIESID);

}
