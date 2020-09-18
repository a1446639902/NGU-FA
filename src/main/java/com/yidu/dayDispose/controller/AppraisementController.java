package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import com.yidu.dayDispose.pojo.*;
import com.yidu.dayDispose.service.AppraisementService;
import com.yidu.inventoryManage.pojo.CashClosedPayInventory;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventoryPojo;
import com.yidu.inventoryManage.service.CashClosedPaylnventoryService;
import com.yidu.inventoryManage.service.SecuritiesClosedPayInventoryService;
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

    @RequestMapping("selectValuationProcessing")
    public HashMap selectValuationProcessing() {
        List<ValuationProcessing> valuationProcessingList = appraisementService.selectBiaoge();
        HashMap valuationProcessingMap = new HashMap();
        valuationProcessingMap.put("code",0);
        valuationProcessingMap.put("msg","");
        valuationProcessingMap.put("count",null);
        valuationProcessingMap.put("data",valuationProcessingList);
        System.out.println(valuationProcessingMap);
        return valuationProcessingMap;
    }

    @RequestMapping("startValuation")
    public int startValuation(String toDay,String arrJson ){
        System.out.println("进来了");
        System.out.println(arrJson+" "+toDay);
        int i=0;
        List<ValuationProcessing> valuationProcessingList = JsonUtil.jsonToArrayList(arrJson, ValuationProcessing.class);
        for (ValuationProcessing valuationProcessing : valuationProcessingList) {

                if(valuationProcessing.getStatus().equals("证券估值增值")){
                    System.out.println("证券估值增值开始估值");
                    HashMap stockarketMap = appraisementService.selectStockarket(toDay);
                    List<StockSecuritiesJoinMarket> stockSecuritiesJoinMarketList = (List<StockSecuritiesJoinMarket>) stockarketMap.get("p_cursor");
                    for (StockSecuritiesJoinMarket stockSecuritiesJoinMarket : stockSecuritiesJoinMarketList) {
                        System.out.println( stockSecuritiesJoinMarket.getSecuritiesId()+"========================================");
                        SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo = new SecuritiesClosedPayInventoryPojo();
                        //开始执行增加
                        securitiesClosedPayInventoryPojo.setFundId(stockSecuritiesJoinMarket.getFundId());
                        securitiesClosedPayInventoryPojo.setSecuritiesId(stockSecuritiesJoinMarket.getSecuritiesId());
                        securitiesClosedPayInventoryPojo.setDateTime(stockSecuritiesJoinMarket.getDateTime());
//                        System.out.println(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI)+"=============================== 这是scpi的Id");
//                        securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
//                        securitiesClosedPayInventoryPojo.setDateTime(toDay);
//                        securitiesClosedPayInventoryPojo.setSecuritiesType(1);
//                        securitiesClosedPayInventoryPojo.setFlag(1);
//                        securitiesClosedPayInventoryPojo.setTotalPrice(stockSecuritiesJoinMarket.getTootaIPrice());
                        securitiesClosedPayInventoryPojo.setSecuritiesClosedPayDesc("投资有风险");
//                        System.out.println("=============================增加的实体类"+securitiesClosedPayInventoryPojo);
//                        i = securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        System.out.println(securitiesClosedPayInventoryPojo+"这是第二个的删除实体类");
//                        执行删除
                        int i1 = appraisementService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        System.out.println("============================================="+i1);
                        System.out.println(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI)+"=============================== 这是scpi的Id");
                        securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                        securitiesClosedPayInventoryPojo.setSecuritiesType(1);
                        securitiesClosedPayInventoryPojo.setFlag(1);
                        securitiesClosedPayInventoryPojo.setTotalPrice(stockSecuritiesJoinMarket.getTootaIPrice());
                        securitiesClosedPayInventoryPojo.setSecurityPeriodFlag(stockSecuritiesJoinMarket.getSecurityPeriodFlag());
//                        //调用增加方法
                        int i2 = securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        System.out.println(i2+"第二次插入的返回值");

                    }
                }else {
                    System.out.println("清算款清算中");
                    //查交易数据 按证券代码分组 插入证券应收应付库存
                    HashMap hashMap = appraisementService.selectTransactionData(toDay);
                    List<TransactionData> transactionDataList = (List<TransactionData>)hashMap.get("p_cursor");
                    for (TransactionData transactionData : transactionDataList) {
                        System.out.println("TransactionData================="+transactionData);
                        SecuritiesClosedPayInventoryPojo securitiesClosedPayInventoryPojo = new SecuritiesClosedPayInventoryPojo();
                        securitiesClosedPayInventoryPojo.setSecuritiesClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                        securitiesClosedPayInventoryPojo.setFundId(transactionData.getFundId());
                        securitiesClosedPayInventoryPojo.setSecuritiesId(transactionData.getSecuritiesId());
                        securitiesClosedPayInventoryPojo.setDateTime(toDay);

                        System.out.println("删除证券应收应付的实体类"+securitiesClosedPayInventoryPojo);
                        appraisementService.deleteSecuritiesClosedPayInventoryTwo(securitiesClosedPayInventoryPojo);
                        securitiesClosedPayInventoryPojo.setDateTime(toDay);
                        securitiesClosedPayInventoryPojo.setSecurityPeriodFlag(1);
                        securitiesClosedPayInventoryPojo.setSecuritiesType(2);
                        securitiesClosedPayInventoryPojo.setFlag(1);
                        securitiesClosedPayInventoryPojo.setTotalPrice(transactionData.getTotalSum());

                        securitiesClosedPayInventoryService.insertSecuritiesClosedPayInventory(securitiesClosedPayInventoryPojo);
                        System.out.println("查ta交易数据================================");
                        HashMap taTransactionMap = appraisementService.selectTaTransaction(toDay);
                        List<TaTransaction> taTransactionList = (List<TaTransaction>)taTransactionMap.get("p_cursor");
                        for (TaTransaction taTransaction : taTransactionList) {
                            System.out.println(taTransaction+"ta==========================================");
                            CashClosedPayInventory cashClosedPayInventory = new CashClosedPayInventory();
                            cashClosedPayInventory.setCashClosedPayInventoryId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCPI));
                            cashClosedPayInventory.setBusinessDate(toDay);
                            cashClosedPayInventory.setFundId(taTransaction.getFundId());
                            System.out.println(taTransaction.getAccountId()+"=============================accountId");
                            cashClosedPayInventory.setAccountId(taTransaction.getAccountId());
                            System.out.println(cashClosedPayInventory+"删除前的实体类=======================");
                            //删除accountId无效
//                            appraisementService.deleteCashClosedPaylnventory(cashClosedPayInventory);
                            cashClosedPayInventory.setBusinessType(4);
                            cashClosedPayInventory.setBusinessStatus(-1);
                            cashClosedPayInventory.setInitialSigns(1);
                            cashClosedPayInventory.setTotalMoney((int)taTransaction.getTotalMoney());
                            System.out.println(cashClosedPayInventory);
                            i = cashClosedPaylnventoryService.insertCashClosedPaylnventory(cashClosedPayInventory);

                        }

                    }

                }
        }
        return i;
    }
}
