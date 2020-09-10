package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.InventoryMapper;
import com.yidu.dayDispose.pojo.InventoryEntity;
import com.yidu.dayDispose.pojo.InventorySecurityEntity;
import com.yidu.dayDispose.service.InventoryService;
import com.yidu.inventoryManage.mapper.SecuritiesInventoryMapper;
import com.yidu.inventoryManage.pojo.SecuritiesInventory;
import com.yidu.inventoryManage.service.SecuritiesInventoryService;
import com.yidu.util.DbUtil;
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

    //得到库存统计的Mapper方法
    @Resource
    private InventoryMapper inventoryMapper;

    //得到证券库存的service
    @Resource
    private SecuritiesInventoryService securitiesInventoryService;


    //得到工具类
    @Resource
    DbUtil dbUtil;

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

        if (invId !=null && !invId.equals("")){


           String[] split =null;
           split = invId.split(",");

        //定义一个id用于循环接收删除id
        String intId;

        //循环遍历切割的数组，if判断  1，统计现金库存 2.统计证券库存 3.统计TA库存 4.统计证券应收应付库存  5.统计现金应收应付库存
        for (String s : split) {
            intId = s;

            if (s.equals("1")){
                //统计现金库存的操作
                System.out.println("我是统计现金库存的操作");

            }else if (s.equals("2")){
                //统计证券库存的操作

                List<InventorySecurityEntity> inventorySecurityEntities = inventoryMapper.selectInvventory(dateTime3,"289289289");

                /**
                 * 显示在库存统计中的证券库存统计完之后的信息
                 *
                 * 1.库存名称  不变   证券库存
                 * 2.基金编号  统计的基金编号
                 * 3.操作员    从角色获得
                 * 4.统计日期   统计的日期
                 * 5.已统计的数据   数组的长度（统计了几条就有几条数据）
                 * 6.统计状态   修改为已统计
                 */
                inventoryEntity2 = new InventoryEntity(2,"证券库存","289289289","admain",dateTime3,inventorySecurityEntities.size(),"已统计");

                for (InventorySecurityEntity inventorySecurityEntity : inventorySecurityEntities) {
                    System.out.println("我是统计证券库存的操作,我统计的数据为："+inventorySecurityEntity);
                    //调用证券库存 删除 条件：库存统计选择的日期，id
                    securitiesInventoryService.deleteDateSecuritiesInventory(dateTime3);




                    //插入统计之后的新数据
                        //调用 实体类新增
                    SecuritiesInventory securitiesInventory = new SecuritiesInventory();
                        //证券库存ID
                        securitiesInventory.setSecuritiesInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.M));

                        //证券库存日期
                        securitiesInventory.setDateTime(dateTime3);

                        //证券信息表ID
                        securitiesInventory.setSecuritiesId(inventorySecurityEntity.getSecuritiesId());

                        //基金表ID
                        securitiesInventory.setFundId("289289289");

                        //是否导入其他系统数据
                        securitiesInventory.setSecurityPeriodFlag(0);

                        //证券的数量
                        securitiesInventory.setSecuritiesNum(inventorySecurityEntity.getTodayNum());


                        //单位成本
                        securitiesInventory.setPrice(inventorySecurityEntity.getUnitPrice());

                        //总金额
                        securitiesInventory.setTotal(inventorySecurityEntity.getTodayTotal());


                        //备注
                        securitiesInventory.setSecuritiesInventoryDesc("库存统计统计的日期");
                    System.out.println("我是证券库存的实体类："+securitiesInventory);
                    securitiesInventoryService.insertSecuritiesInventory(securitiesInventory);

                }




            }else if (s.equals("3")){
                //统计TA库存的操作
                System.out.println("我是统计TA库存的操作");


            }else if (s.equals("4")){
                //统计证券应收应付库存的操作
                System.out.println("我是统计证券应收应付库存的操作");

            }else {
                //统计现金应收应付库存的操作
                System.out.println("我是统计现金应收应付库存的操作");


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
