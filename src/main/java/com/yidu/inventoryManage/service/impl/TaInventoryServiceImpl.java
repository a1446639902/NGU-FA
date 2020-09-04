package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.TaInventoryMapper;
import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import com.yidu.inventoryManage.service.TaInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
     * date: 获得网页根据日期查询的信息（若为空则调用查询所有）
     *
     * @return 查询的结果List
     */
    @Override
    public List<TaInventoryEntity> selectTaInventory() {
        return taInventoryMapper.selectTaInventory();
    }


    /**
     * 删除TaInventory（Ta库存）表的service实现方法
     * @return
     */
    @Override
    public void deleteTaInventory(String deleteId) {
        taInventoryMapper.deleteTaInventory(deleteId);
    }

    /**
     * 批量删除TaInventory（Ta库存）表的service实现方法
     *
     * @return
     */
    @Override
    public void deleteMoreTaInventory(String taInventoryId) {
        String[] split = taInventoryId.split(",");
//        ArrayList<Object> arrayList = new ArrayList<>();

        //定义一个id用于循环接收删除id
        String deleteId;
        for (String id : split) {
//           deleteId=Integer.parseInt(id);
           //循环获得的批量删除id
           taInventoryMapper.deleteTaInventory(id);
        }

    }

    /**
     * 修改TaInventory（Ta库存）表的service实现方法
     * @return
     */
    @Override
    public void updateTaInventory(double tanum, double tatotal,String taInventoryId) {
        taInventoryMapper.updateTaInventory(tanum,tatotal,taInventoryId);
    }

}
