package com.yidu.inventoryManage.service;

import com.yidu.inventoryManage.pojo.TaInventoryEntity;

import java.util.List;

/**
 * Ta库存的service层
 * @Mr.Zou
 * date：2020/9/2
 */
public interface TaInventoryService {

    /**
     * 查询TaInventory（库存统计）表 service接口
     * @return
     */
    public List<TaInventoryEntity> selectTaInventory();


    /**
     * 删除TaInventory（库存统计）表 service接口
     * @return
     */
    public void deleteTaInventory(String deleteId);

    /**
     * 批量删除TaInventory（库存统计）表 service接口
     * @return
     */
    public void deleteMoreTaInventory(String taInventoryId);

    /**
     * 修改TaInventory（库存统计）表 service接口
     * @return
     */
    public void updateTaInventory(double tanum,double tatotal,String taInventoryId);

}
