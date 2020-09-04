package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Ta库存的Dao层接口
 * @Mr.Zou
 * date：2020/9/2
 */
@Mapper
public interface TaInventoryMapper {

    /**
     * 查询taInventory（Ta库存表）
     * @return
     */
    @Select("select taInventoryId,TAINVENTORY.FUNDID,tanum,tatotal,dateTime,taInventoryDesc,FUNDNAME from taInventory,fund where FUND.FUNDID = TAINVENTORY.FUNDID")
    public List<TaInventoryEntity> selectTaInventory();


    /**
     * 根据日期查询taInventory（Ta库存表）
     * @return
     */
    @Select("select taInventoryId,TAINVENTORY.FUNDID,tanum,tatotal,dateTime,taInventoryDesc,FUNDNAME from taInventory,fund where FUND.FUNDID = TAINVENTORY.FUNDID and dateTime=#{date}")
    public List<TaInventoryEntity> selectDateTaInventory(String date);

    /**
     * 根据ID删除taInventory（Ta库存表）
     */
    @Delete("delete from taInventory where taInventoryId=#{deleteId}")
    public void deleteTaInventory(String deleteId);

    /**
     * 修改taInventory（Ta库存表）
     * @param tanum
     * @param tatotal
     */
    @Update("update taInventory set tanum=#{tanum},tatotal=#{tatotal} where taInventoryId=#{taInventoryId}")
    public void updateTaInventory(double tanum,double tatotal,String taInventoryId);

    /**
     * 新增taInventory（Ta库存表）
     */
    @Insert("insert into taInventory values (#{taInventoryId},#{fundId},#{tanum},#{tatotal},#{dateTime},#{securityPeriodFlag},#{taInventorydesc})")
    public void insertTaInventory(TaInventoryEntity taInventoryEntity);


}
