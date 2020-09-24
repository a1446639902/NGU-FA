package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.InventoryMapper;
import com.yidu.dayDispose.pojo.*;
import com.yidu.dayDispose.service.InventoryService;
import com.yidu.inventoryManage.mapper.*;
import com.yidu.inventoryManage.pojo.*;
import com.yidu.inventoryManage.service.SecuritiesInventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.GetFundIdUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    //得到现金库存的mapper方法
    @Resource
    private CashInventoryMapper cashInventoryMapper;

    //得到TA库存的Mapper方法
    @Resource
    private TaInventoryMapper taInventoryMapper;

    //得到现金应收应付表的Mapper方法
    @Resource
    private CashClosedPaylnventoryMapper cashClosedPaylnventoryMapper;

    @Resource
    //得到证券应收应付库存的Mapper方法
    private SecuritiesClosedPayInventoryMapper securitiesClosedPayInventoryMapper;

    //得到工具类
    @Resource
    DbUtil dbUtil;

    /**
     * 显示在网页的库存状态信息
     * @return
     */
    @Override
    public List<InventoryEntity> selectInventory(HttpServletRequest request, String dateTime3, String invId) {

        //获得基金id
        String fundId = GetFundIdUtil.getFundId(request);


    //刚进入库存统计页面的默认显示信息
        //创建一个List 用于保存库存状态信息
        List<InventoryEntity>list=new ArrayList<InventoryEntity>();
        //现金库存的信息
        InventoryEntity inventoryEntity = new InventoryEntity(1,"现金库存",fundId,"admain","",0,"暂无");
        //证卷库存的信息
        InventoryEntity inventoryEntity2 = new InventoryEntity(2,"证券库存",fundId,"admain","",0,"暂无");
        //TA库存的信息
        InventoryEntity inventoryEntity3 = new InventoryEntity(3,"TA库存",fundId,"admain","",0,"暂无");
        //证券应收应付库存的信息
        InventoryEntity inventoryEntity4 = new InventoryEntity(4,"证券应收应付库存",fundId,"admain","",0,"暂无");
        //现金应收应付库存的信息
        InventoryEntity inventoryEntity5 = new InventoryEntity(5,"现金应收应付库存",fundId,"admain","",0,"暂无");


        System.out.println("我是库存统计的service层****************我获得的日期为："+dateTime3+"我需要统计的库存Id为："+invId+"基金ID为"+fundId);
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

                //调用现金库存的统计mapper方法
                List<CaInventoryEntity> caInventoryEntities = inventoryMapper.selectCaInventory(dateTime3, fundId);

                //统计完之后将库存显示  现金库存页面修改为已统计状态
                inventoryEntity = new InventoryEntity(1,"现金库存",fundId,"admain",dateTime3,caInventoryEntities.size(),"已统计");


                for (CaInventoryEntity caInventoryEntity : caInventoryEntities) {
                    System.out.println("我是库存统计之现金库存统计，我获得的数据为："+caInventoryEntity);
                    CashInventoryEntity cashInventoryEntity1 = new CashInventoryEntity();
                    //调用现金库存的根据日期删除方法，删除库存统计之前的数据
                    cashInventoryMapper.deleteDateInventor(dateTime3,cashInventoryEntity1.getAccountId(),cashInventoryEntity1.getFundId());

                    //插入库存统计之后的新数据
                    CashInventoryEntity cashInventoryEntity = new CashInventoryEntity();
                    //现金库存ID
                    cashInventoryEntity.setCashInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CI));
                    //基金ID 来自基金表
                    cashInventoryEntity.setFundId(fundId);
                    //现金余额
                    cashInventoryEntity.setCashBlance(caInventoryEntity.getSumCa());
                    //账户ID
                    cashInventoryEntity.setAccountId("000899001");
                    //统计日期
                    cashInventoryEntity.setDateTime(dateTime3);
                    //证券数量
                    cashInventoryEntity.setSecuritiesNum(0);
                    //期初数据
                    cashInventoryEntity.setSecurityPeriodFlag(0);
                    //备注
                    cashInventoryEntity.setCashInventoryDesc("库存统计的数据");
                    cashInventoryMapper.insertCashInventory(cashInventoryEntity);
                }

            }else if (s.equals("2")){
                //统计证券库存的操作
                System.out.println("我是证券库存");
                List<InventorySecurityEntity> inventorySecurityEntities = inventoryMapper.selectInvventory(dateTime3,fundId);

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
                inventoryEntity2 = new InventoryEntity(2,"证券库存",fundId,"admain",dateTime3,inventorySecurityEntities.size(),"已统计");

                for (InventorySecurityEntity inventorySecurityEntity : inventorySecurityEntities) {
                    System.out.println("我是统计证券库存的操作,我统计的数据为："+inventorySecurityEntity);



                    //调用证券库存 删除 条件：库存统计选择的日期，id
                    securitiesInventoryService.deleteDateSecuritiesInventory(dateTime3,inventorySecurityEntity.getSecuritiesId());


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
                    securitiesInventory.setFundId(fundId);
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

                //调用TA库存的统计方法
                List<TaInventoryEntityTwo> taInventoryEntities = inventoryMapper.selectTaInventory(dateTime3, fundId);

                //将库存显示页面的状态修改为统计之后的状态
                inventoryEntity3 = new InventoryEntity(3,"TA库存",fundId,"admain",dateTime3,taInventoryEntities.size(),"已统计");

                //循环遍历 得到的结果
                for (TaInventoryEntityTwo taInventoryEntity : taInventoryEntities) {
                    System.out.println("我是库存统计界面的TA库存，我查询到的结果为："+taInventoryEntity);

                    //调用删除方法，删除库存统计之前的数据
                    taInventoryMapper.deleteDateInventory(dateTime3);
                    //调用新增方法，插入库存统计之后的新数据
                    TaInventoryEntity taInventoryEntity1 = new TaInventoryEntity();

                    //TA库存ID
                    taInventoryEntity1.setTaInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TI));
                    //基金ID
                    taInventoryEntity1.setFundId(fundId);
                    //Ta数量
                    taInventoryEntity1.setTanum(taInventoryEntity.getNuml());
                    //现金余额
                    System.out.println("我是TA库存统计，我得到的余额为："+taInventoryEntity.getTotal());
                    taInventoryEntity1.setTatotal(taInventoryEntity.getTotal());
                    //统计日期
                    taInventoryEntity1.setDateTime(dateTime3);
                    //期初数据
                    taInventoryEntity1.setSecurityPeriodFlag(0);
                    //备注
                    taInventoryEntity1.setTaInventorydesc("库存统计之后的新数据");



                    taInventoryMapper.insertTaInventory(taInventoryEntity1);

                }


            }else if (s.equals("4")){
                //统计证券应收应付库存的操作
                System.out.println("我是统计证券应收应付库存的操作");

                //调用证券应收应付的方法
                List<SeYSYFInventoryEntity> seYSYFInventoryEntities = inventoryMapper.selectSeYSYFInventory(dateTime3, fundId);



                //显示在界面的证券应收应付库存的状态
                inventoryEntity4 = new InventoryEntity(4,"证券应收应付库存",fundId,"admain",dateTime3,seYSYFInventoryEntities.size(),"已统计");


                for (SeYSYFInventoryEntity seYSYFInventoryEntity : seYSYFInventoryEntities) {
                    System.out.println("我是证券应收应付的库存统计，我获得的数据为："+seYSYFInventoryEntity);

                    //调用删除的方法,根据日期，基金信息表Id，证券信息表ID删除库存统计之前的数据
                    securitiesClosedPayInventoryMapper.delectDateTaInventoryPayMapper(dateTime3,fundId,seYSYFInventoryEntity.getSecuritiesId());
                    System.out.println("我在删除之后"+dateTime3);


//                    得到证券应收应付的实体类
                    SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo = new SecuritiesClosedPayInventoryPojo();

                    //证券存库Id 主键
                    securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                    //业务日期
                    securitiesClosedPayInventoryPojo.setDateTime(dateTime3);
                    //FK 基金信息表Id      fund表
                    securitiesClosedPayInventoryPojo.setFundId(fundId);

                    //FK 证券信息表ID  securities表
                    securitiesClosedPayInventoryPojo.setSecuritiesId(seYSYFInventoryEntity.getSecuritiesId());

                    //证券应收应付类型 1=估值款 2=证券清算款 3=债券利息
                    securitiesClosedPayInventoryPojo.setSecuritiesType(3);

                    //如果最后计算的总金额为正数，则为1流入，如果是负数则是流出-1
                    int i=1;
                    if (seYSYFInventoryEntity.getTocal()<0){
                     i=-1;
                        System.out.println("*********************************8_____________________我进来了，我将状态修改为-1"+i);
                    }
                    seYSYFInventoryEntity.setFlag(i);
                    //业务状态 1流入，-1流出
                    securitiesClosedPayInventoryPojo.setFlag(seYSYFInventoryEntity.getFlag());
                    System.out.println("我统计的证券余额为*************************8"+seYSYFInventoryEntity.getTocal());
                    //判断总金额是否为正数，如果是负数，则转换成正数
                    if (seYSYFInventoryEntity.getTocal()<0){
                        //得到证券应收应付的总金额
                        double total= seYSYFInventoryEntity.getTocal();
                        //改变状态
                        total=-total;
                        //将改变之后的状态插入实体类
                        seYSYFInventoryEntity.setTocal(total);
                        System.out.println("我是切割之后的数字————————————————————————————————————————————————"+total);
                    }
                    //总金额
                    securitiesClosedPayInventoryPojo.setTotalPrice(seYSYFInventoryEntity.getTocal());
                    //备注
                    securitiesClosedPayInventoryPojo.setSecuritiesClosedPayDesc("库存统计统计的数据");

                    //期初标志 是否从其他系统导入得期初数据 0：不是 1：是
                    securitiesClosedPayInventoryPojo.setSecurityPeriodFlag(seYSYFInventoryEntity.getSecurityPeriodFlag());

                    System.out.println("我是证券应收应付库存统计，我要统计的数据为："+securitiesClosedPayInventoryPojo);

                    //插入库存统计之后的新数据
                    securitiesClosedPayInventoryMapper.insertTaInventoryPayMapper(securitiesClosedPayInventoryPojo);


                }


            }else {
                //统计现金应收应付库存的操作
                System.out.println("我是统计现金应收应付库存的操作");
                List<CaYSYFInventoryEntity> caYSYFInventoryMappers = inventoryMapper.selectCaYSYFInventory(dateTime3, fundId);
                //将库存显示页面的状态修改为统计之后的状态
                inventoryEntity5 = new InventoryEntity(5, "现金应收应付库存", fundId, "admain", dateTime3, caYSYFInventoryMappers.size(), "已统计");

                CashClosedPayInventory cashClosedPayInventory = new CashClosedPayInventory();
                if (caYSYFInventoryMappers.size() != 0 && caYSYFInventoryMappers.get(0) != null) {
                    for (CaYSYFInventoryEntity caYSYFInventoryMapper : caYSYFInventoryMappers) {
                        System.out.println("我是库存统计的现金库存界面，我获得的数据为" + caYSYFInventoryMapper);
                        System.out.println("我现金应收应付库存之前");
                        //调用删除方法，删除库存统计之前的数据
                        cashClosedPaylnventoryMapper.delectDateInventory(dateTime3,caYSYFInventoryMapper.getAccountId(),caYSYFInventoryMapper.getServ());

                        //调用新增方法 ，插入库存统计之后的界面

                        //现金应收应付库存编号
                        cashClosedPayInventory.setCashClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCPI));
                        //业务日期
                        cashClosedPayInventory.setBusinessDate(dateTime3);
                        //现金账户ID
                        cashClosedPayInventory.setAccountId(caYSYFInventoryMapper.getAccountId());
                        //基金Id
                        cashClosedPayInventory.setFundId(fundId);
                        //业务类型  1.管理费 2.托管费  3.存款利息  4.申购赎回费
                        cashClosedPayInventory.setBusinessType(caYSYFInventoryMapper.getServ());

                        //如果最后计算的总金额为正数，则为1流入，如果是负数则是流出-1
                        int i=1;
                        System.out.println("**********************************我统计的现金余额为："+caYSYFInventoryMapper.getToca());
                        if (caYSYFInventoryMapper.getToca()<0){
                            i=-1;
                            System.out.println("*********************************8_____________________我进来了，我将状态修改为"+i);
                        }
                        caYSYFInventoryMapper.setFla(i);
                        //业务状态 1.流入  -1流出
                        System.out.println("**********************************我插入数据库的业务状态为："+i);
                        cashClosedPayInventory.setBusinessStatus(caYSYFInventoryMapper.getFla());

                        //期初标志 1.是   0.否
                        cashClosedPayInventory.setInitialSigns(0);

                        //判断总金额是否为正数，如果是负数，则转换成正数
                        if (caYSYFInventoryMapper.getToca()<0){
                            //得到证券应收应付的总金额
                            double total= caYSYFInventoryMapper.getToca();
                            //改变状态
                            total=-total;
                            //将改变之后的状态插入实体类
                            caYSYFInventoryMapper.setToca(total);
                            System.out.println("我是切割之后的数字————————————————————————————————————————————————"+total);
                        }

                        //总金额
                        cashClosedPayInventory.setTotalMoney(caYSYFInventoryMapper.getToca());

                        cashClosedPaylnventoryMapper.insertCashClosedPaylnventory(cashClosedPayInventory);
                    }


                }
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
