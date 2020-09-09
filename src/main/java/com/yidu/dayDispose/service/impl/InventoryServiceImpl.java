package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.pojo.InventoryEntity;
import com.yidu.dayDispose.service.InventoryService;
import com.yidu.util.SysTableNameListUtil;
import jdk.jfr.Threshold;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 库存统计的service实现类
 * @Mr.Zou
 **/
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

    /**
     * 显示在网页的库存状态信息
     * @return
     */
    @Override
    public List<InventoryEntity> selectInventory(String dateTime3,String invId) {
    //刚进入库存统计页面的默认显示信息
        //创建一个List 用于保存库存状态信息
        List<InventoryEntity>list=new ArrayList<InventoryEntity>();
        //现金库存的信息
        InventoryEntity inventoryEntity = new InventoryEntity(1,"现金库存","289289289","admain","",0,"暂无");
        //证卷库存的信息
        InventoryEntity inventoryEntity2 = new InventoryEntity(2,"证券库存","289289289","admain","",0,"暂无");
        //TA库存的信息
        InventoryEntity inventoryEntity3 = new InventoryEntity(3,"TA库存","289289289","admain","",0,"暂无");
        //证券应收应付库存的信息
        InventoryEntity inventoryEntity4 = new InventoryEntity(4,"证券应收应付库存","289289289","admain","",0,"暂无");
        //现金应收应付库存的信息
        InventoryEntity inventoryEntity5 = new InventoryEntity(5,"现金应收应付库存","289289289","admain","",0,"暂无");


        System.out.println("我是库存统计的service层****************我获得的日期为："+dateTime3+"我需要统计的库存Id为："+invId);
        //根据返回的日期，和需要统计的库存id  进行统计
        //当invId不等于空 切割获得的id 字符串数组保存

        if (invId != "" && invId!=null){
            String[] split =null;
           split = invId.split(",");



        //定义一个id用于循环接收删除id
        String intId;

        //循环遍历切割的数组，if判断  1，统计现金库存 2.统计证券库存 3.统计TA库存 4.统计证券应收应付库存  5.统计现金应收应付库存
        for (String s : split) {
            intId = s;

            if (s == "1"){

            }else if (s == "2"){
                //统计证券库存的操作
                System.out.println("我是统计证券库存的操作");

            }else if (s == "3"){

            }else if (s == "4"){

            }else {

            }

        }
    }

        //将默认的数据写入集合丢入网页显示
        list.add(inventoryEntity);
        list.add(inventoryEntity2);
        list.add(inventoryEntity3);
        list.add(inventoryEntity4);
        list.add(inventoryEntity5);


        return list;
    }

}
