package com.yidu.inventoryManage.service.impl;

import com.yidu.inventoryManage.mapper.TaInventoryMapper;
import com.yidu.inventoryManage.pojo.TaInventoryEntity;
import com.yidu.inventoryManage.service.TaInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Ta库存的service层接口实现类
 * @Mr.Zou
 * date:2020/9/2
 */
@Service
@Transactional
public class TaInventoryServiceImpl implements TaInventoryService {

    @Resource
    private TaInventoryMapper taInventoryMapper;

    @Resource
    DbUtil dbUtil;
    /**
     * 查询TaInventory（Ta库存）表的service实现方法
     * date: 获得网页根据日期查询的信息（若为空则调用查询所有）
     *
     * @return 查询的结果List
     */
    @Override
    public List<TaInventoryEntity> selectTaInventory(String datetime) {
        if (datetime == null || datetime =="") {
            return taInventoryMapper.selectTaInventory();
        }else {
            return taInventoryMapper.selectDateTaInventory(datetime);
        }
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

    /**
     * 新增taInventory（Ta库存表）
     */
    @Override
    public void insertTaInventory(TaInventoryEntity taInventoryEntity) {

        //设置TA库存"100001"Id
        taInventoryEntity.setTaInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TI));

        //是否为期初数据，0不是，1 是"ertyuio"
        taInventoryEntity.setSecurityPeriodFlag(1);


        //基金Id
        taInventoryEntity.setFundId("289289289");


        System.out.println("TA库存Id"+taInventoryEntity.getTaInventoryId());
        System.out.println("基金Id来自基金表"+taInventoryEntity.getFundId());
        System.out.println("Ta数量"+taInventoryEntity.getTanum());
        System.out.println("现金余额"+taInventoryEntity.getTatotal());
        System.out.println("统计日期"+taInventoryEntity.getDateTime());
        System.out.println("是否从其他系统导入的期初数据"+taInventoryEntity.getSecurityPeriodFlag());
        System.out.println("备注"+taInventoryEntity.getTaInventorydesc());

        taInventoryMapper.insertTaInventory(taInventoryEntity);
    }

}
