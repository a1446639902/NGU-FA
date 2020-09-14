package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.SeInventoryPayEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 证券应收应付的Mapper
 * @Mr.Zou
 **/
@Mapper
public interface SeInventoryPayMapper {

    /**
     * 证券应收应付的实体类
     * @param taInventoryPayEntity
     */
    @Insert("insert into securitiesClosedPayInventory values (#{securitiesClosedPayInventoryId}," +
            "#{dateTime},#{fundId},#{securitiesId},#{securitiesType},#{flag},#{totalPrice},#{securitiesClosedPayDesc},#{securityPeriodFlag})")
    public void insertTaInventoryPayMapper(SeInventoryPayEntity taInventoryPayEntity);


    /**
     * 根据日期删除的方法
     * @param date
     */
    @Delete("delete securitiesClosedPayInventory where dateTime=#{date}")
    public void delectDateTaInventoryPayMapper(String date);

}
