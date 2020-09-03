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
     * 新增TaInventory（库存统计）表 service接口
     * @return
     */
    public void insertTaInventory(TaInventoryEntity taInventoryEntity);

    /**
     * 删除TaInventory（库存统计）表 service接口
     * @return
     */
    public void deleteTaInventory(int deleteId);
}
