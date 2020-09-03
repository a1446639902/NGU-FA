package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.TaInventoryMapper;
import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import com.yidu.inventoryManage.service.TaInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Ta库存的service层接口实现类
 * @Mr.Zou
 * date:2020/9/2
 */
@Service
public class TaInventoryServiceImpl implements TaInventoryService {

    @Resource
    private TaInventoryMapper taInventoryMapper;

    /**
     * 查询TaInventory（Ta库存）表的service实现方法
     * @return
     */
    @Override
    public List<TaInventoryEntity> selectTaInventory() {
        return taInventoryMapper.selectTaInventory();
    }

    /**
     * 新增TaInventory（Ta库存）表的service实现方法
     * @return
     */
    @Override
    public void insertTaInventory(TaInventoryEntity taInventoryEntity) {
        taInventoryMapper.insertTaInventory(taInventoryEntity);
    }

    /**
     * 删除TaInventory（Ta库存）表的service实现方法
     * @return
     */
    @Override
    public void deleteTaInventory(int deleteId) {
        taInventoryMapper.deleteTaInventory(deleteId);
    }

}
