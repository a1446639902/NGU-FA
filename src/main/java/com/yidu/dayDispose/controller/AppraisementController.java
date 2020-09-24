package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.dayDispose.pojo.*;
import com.yidu.dayDispose.service.AppraisementService;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import com.yidu.inventoryManage.service.CashClosedPaylnventoryService;
import com.yidu.inventoryManage.service.SecuritiesClosedPayInventoryService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.taManage.pojo.TaTransaction;
import com.yidu.util.DbUtil;
import com.yidu.util.JsonUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("Appraisement")
public class AppraisementController {
    @Resource
    AppraisementService appraisementService;
    @Resource
    SecuritiesClosedPayInventoryService securitiesClosedPayInventoryService;
    @Resource
    DbUtil dbUtil;
    @Resource
    CashClosedPaylnventoryService cashClosedPaylnventoryService;

    @NGULog(message = "查询页面状态")
    @RequestMapping("selectValuationProcessing")
    public HashMap selectValuationProcessing() {
        //资产估值表格内容写死通过appraisementService.selectBiaoge();  获取ValuationProcessing类型的集合  数据是写死的
        List<ValuationProcessing> valuationProcessingList = appraisementService.selectBiaoge();
        HashMap valuationProcessingMap = new HashMap();
        valuationProcessingMap.put("code", 0);
        valuationProcessingMap.put("msg", "");
        valuationProcessingMap.put("count", null);
        valuationProcessingMap.put("data", valuationProcessingList);
        System.out.println(valuationProcessingMap);
        return valuationProcessingMap;
    }

    @NGULog(message = "查询证券库存join行情表,ta交易数据以及交易数据")
    @RequestMapping("startValuation")
    //toDay字符串是查询的条件 arrJson是传过来的json对象字符串
    public int startValuation(String toDay, String arrJson) {
        System.out.println("进来了");
        System.out.println(arrJson + " " + toDay);
        int i = 0;
        //工具类获得  ValuationProcessing是解析后的实体类
        List<ValuationProcessing> valuationProcessingList = JsonUtil.jsonToArrayList(arrJson, ValuationProcessing.class);
        for (ValuationProcessing valuationProcessing : valuationProcessingList) {
            //getStatus是状态名字  比如证券估值增值或者清算款
            if (valuationProcessing.getStatus().equals("证券估值增值")) {
                System.out.println("证券估值增值开始估值");
                //方法名为selectStockarket 通过日期查询估值增值
                HashMap stockarketMap = appraisementService.selectStockarket(toDay);
                //p_cursor 得到StockSecuritiesJoinMarket 类型的集合  方法名为stockarketMap
                List<StockSecuritiesJoinMarket> stockSecuritiesJoinMarketList = (List<StockSecuritiesJoinMarket>) stockarketMap.get("p_cursor");
                for (StockSecuritiesJoinMarket stockSecuritiesJoinMarket : stockSecuritiesJoinMarketList) {
                    System.out.println(stockSecuritiesJoinMarket+"估值增值==============");

                    //new一个SecuritiesClosedPayInventoryPojo类型的集合往里面赋值
                    SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo = new SecuritiesClosedPayInventoryPojo();
//
                    securitiesClosedPayInventoryPojo.setFundId(stockSecuritiesJoinMarket.getFundId());

                    securitiesClosedPayInventoryPojo.setSecuritiesId(stockSecuritiesJoinMarket.getSecuritiesId());

                    securitiesClosedPayInventoryPojo.setDateTime(stockSecuritiesJoinMarket.getDateTime());
                       //setSecuritiesClosedPayDesc内容是写死的
                    securitiesClosedPayInventoryPojo.setSecuritiesClosedPayDesc("投资有风险");
                    System.out.println(securitiesClosedPayInventoryPojo + "这是第二个的删除实体类");

                    //dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI)获取Id
                    System.out.println(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI) + "=============================== 这是scpi的Id");
                    //setSecuritiesClosedPayInventoryId
                    securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                    //setSecuritiesType 类型为1
                    securitiesClosedPayInventoryPojo.setSecuritiesType(1);
                    //setFlag 类型为1
                    securitiesClosedPayInventoryPojo.setFlag(1);

                    securitiesClosedPayInventoryPojo.setTotalPrice(stockSecuritiesJoinMarket.getTootaIPrice());

                    securitiesClosedPayInventoryPojo.setSecurityPeriodFlag(stockSecuritiesJoinMarket.getSecurityPeriodFlag());
                    //调用增加方法
                    i = securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                    if (i > 0) {
                        //删
                        i = appraisementService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        if (i > 0) {
                            //增
                            i = securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        }
                    }
                    System.out.println(i + "第二次插入的返回值");
                }

            } else {
                System.out.println("清算款清算中");
                //查交易数据 按证券代码分组 插入证券应收应付库存 调用selectTransactionData方法 查询参数为toDay 返回Map集合
                HashMap hashMap = appraisementService.selectTransactionData(toDay);
                //通过键 p_cursor得到TransactionData类型的集合
                List<TransactionData> transactionDataList = (List<TransactionData>) hashMap.get("p_cursor");
                for (TransactionData transactionData : transactionDataList) {
                    System.out.println("TransactionData=================" + transactionData);
                    //new证券应收应付实体类
                    SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo = new SecuritiesClosedPayInventoryPojo();
                    //工具类requestDbTableMaxId 方法通过SCPI得到最大Id复制给证券应收应付Id
                    securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));

                    securitiesClosedPayInventoryPojo.setFundId(transactionData.getFundId());

                    securitiesClosedPayInventoryPojo.setSecuritiesId(transactionData.getSecuritiesId());

                    securitiesClosedPayInventoryPojo.setDateTime(toDay);
                    //setSecurityPeriodFlag 值为1
                    securitiesClosedPayInventoryPojo.setSecurityPeriodFlag(1);
                    //setSecuritiesType 值为2
                    securitiesClosedPayInventoryPojo.setSecuritiesType(2);
                    //setFlag 值为1
                    securitiesClosedPayInventoryPojo.setFlag(-1);
                    //setTotalPrice getTotalSum 数据库两个表字段不一样
                    securitiesClosedPayInventoryPojo.setTotalPrice(transactionData.getTotalSum());
                    System.out.println(securitiesClosedPayInventoryPojo + "插入证券库存2========================");

                    i = securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                    System.out.println("证券应收应付库存第一次插入的I"+i);
                    if (i > 0) {
                        i = appraisementService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        System.out.println("证券应收应付库存第一次删除的I"+i);
                        if (i > 0) {
                            i = securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                            System.out.println("证券应收应付库存第一二次插入的I"+i);
                        }
                    }

                    System.out.println("查ta交易数据================================");
                    //selectTaTransaction 通过selectTaTransaction方法得到map集合
                    HashMap taTransactionMap = appraisementService.selectTaTransaction(toDay);
                    //通过p_cursor建得到TaTransaction类型的集合
                    List<TaTransaction> taTransactionList = (List<TaTransaction>) taTransactionMap.get("p_cursor");
                    //遍历集合
                    for (TaTransaction taTransaction : taTransactionList) {
                        System.out.println(taTransaction + "ta==========================================");
                        //new 现金应收应付实体类
                        CashClosedPayInventory cashClosedPayInventory = new CashClosedPayInventory();
                        //dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCPI） 得到现金应收应付的Id放入现金应收应付
                        cashClosedPayInventory.setCashClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCPI));
                        //setBusinessDate 时间为搜索日期
                        cashClosedPayInventory.setBusinessDate(toDay);
                        //setFundId
                        cashClosedPayInventory.setFundId(taTransaction.getFundId());
                        System.out.println(taTransaction.getAccountId() + "=============================accountId");
                        //setAccountId
                        cashClosedPayInventory.setAccountId(taTransaction.getAccountId());
                        System.out.println(cashClosedPayInventory + "删除前的实体类=======================");
                        //setBusinessType 值为4
                        cashClosedPayInventory.setBusinessType(4);
                        //setBusinessStatus 值为-1
                        cashClosedPayInventory.setBusinessStatus(-1);
                        //setInitialSigns 值为1
                        cashClosedPayInventory.setInitialSigns(1);
                        //setTotalMoney  实体类是int类型，必须强转
                        cashClosedPayInventory.setTotalMoney((int) taTransaction.getTotalMoney());
                        System.out.println(cashClosedPayInventory);
                        //现金应收应付的service调用现金应收应付增加的方法
                        i = cashClosedPaylnventoryService.insertCashClosedPaylnventory(cashClosedPayInventory);
                        System.out.println("现金应收应付库存第一次插入的I"+i);
                        if (i > 0) {
                            //删除的方法自己写 按条件删除
                            i = appraisementService.deleteCashClosedPaylnventory(cashClosedPayInventory);
                            System.out.println("现金应收应付库存第一次删除的I"+i);
                            if (i > 0) {
                                i = cashClosedPaylnventoryService.insertCashClosedPaylnventory(cashClosedPayInventory);
                                System.out.println("现金应收应付库存第二次插入的I"+i);
                            }
                        }


                    }

                }

            }
        }
            return i;

        }
}
