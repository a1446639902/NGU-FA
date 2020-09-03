package com.yidu.inventoryManage.mapper;

import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
     * 新增taInventory（Ta库存表）
     * @param taInventoryEntity
     */
    @Insert("insert into taInventory values (#{taInventoryId},#{fundId},#{tanum},#{tatotal},#{dateTime},#{securityPeriodFlag},#{taInventorydesc})")
    public void insertTaInventory(TaInventoryEntity taInventoryEntity);

    /**
     * 根据ID删除taInventory（Ta库存表）
     */
    @Delete("delete from taInventory where taInventoryId=#{deleteId}")
    public void deleteTaInventory(int deleteId);

}
