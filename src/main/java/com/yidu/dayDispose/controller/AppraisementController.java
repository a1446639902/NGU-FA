package com.yidu.dayDispose.controller;

import com.yidu.dayDispose.pojo.Appraisement;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.dayDispose.pojo.StockSecuritiesJoinMarket;
import com.yidu.dayDispose.pojo.ValuationProcessing;
import com.yidu.dayDispose.service.AppraisementService;
import com.yidu.inventoryManage.pojo.SecuritiesClosedPayInventory;
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
    DbUtil dbUtil;

    @RequestMapping("selectValuationProcessing")
    public HashMap selectValuationProcessing() {
        List<Appraisement> appraisements = appraisementService.selectValuationProcessing();
        HashMap valuationProcessingMap = new HashMap();
        valuationProcessingMap.put("code",0);
        valuationProcessingMap.put("msg","");
        valuationProcessingMap.put("count",null);
        valuationProcessingMap.put("data",appraisements);
        System.out.println(valuationProcessingMap);
        return valuationProcessingMap;
    }
    //判断是否估值，没有估值则开始估值
    @RequestMapping("startValuation")
    public int startValuation(String toDay,String arrJson ){
        System.out.println("进来了");
        System.out.println(arrJson+" "+toDay);
        List<ValuationProcessing> valuationProcessingList = JsonUtil.jsonToArrayList(arrJson, ValuationProcessing.class);
        for (ValuationProcessing valuationProcessing : valuationProcessingList) {
            //如果实体类的日期跟当天日期一样代表当天已经估值完成了,否则继续估值
            if(valuationProcessing.getDateTime().equals("2020-09-13")){
                System.out.println("一样的");
                return 2;
            }else {
                System.out.println("不一样");
                //如果名字为证券库存则查询证券库存join行情数据表 插入应收应付库存，修改估值增值状态表的时间
                if(valuationProcessing.getStatus().equals("证券估值增值")){
                    System.out.println("证券估值增值开始估值");
                    HashMap stockarketMap = appraisementService.selectStockarket();
                    List<StockSecuritiesJoinMarket> stockSecuritiesJoinMarketList = (List<StockSecuritiesJoinMarket>) stockarketMap.get("p_cursor");
                    for (StockSecuritiesJoinMarket stockSecuritiesJoinMarket : stockSecuritiesJoinMarketList) {
                        System.out.println( stockSecuritiesJoinMarket.getSecuritiesId()+"========================================");
                        //开始执行删除
                        SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory();
                        securitiesClosedPayInventory.setFundId(stockSecuritiesJoinMarket.getFundId());
                        securitiesClosedPayInventory.setSecuritiesId(stockSecuritiesJoinMarket.getSecuritiesId());
                        securitiesClosedPayInventory.setSecurityPeriodFlag(stockSecuritiesJoinMarket.getSecurityPeriodFlag());
//                        SecuritiesClosedPayInventory securitiesClosedPayInventory = new SecuritiesClosedPayInventory();
//                        securitiesClosedPayInventory.setFundId("289289289");
//                        securitiesClosedPayInventory.setSecuritiesId("600990");
//                        securitiesClosedPayInventory.setSecurityPeriodFlag(1);
                        int i = appraisementService.deleteSecuritiesClosedPayInventory(securitiesClosedPayInventory);
                        System.out.println("============================================="+i);
                        //开始执行增加
                        securitiesClosedPayInventory.setNsrcsId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCPI));
                        securitiesClosedPayInventory.setDatetime(toDay);
                        securitiesClosedPayInventory.setSecuritiesType(1);
                        securitiesClosedPayInventory.setFlag(1);
                        securitiesClosedPayInventory.setTootaIPrice(stockSecuritiesJoinMarket.getTootaIPrice());
                        securitiesClosedPayInventory.setDesc("投资有风险");
                        securitiesClosedPayInventory.setSecurityPeriodFlag(stockSecuritiesJoinMarket.getSecurityPeriodFlag());
                        //调用增加方法 等待中

                        //修改状态表的状态
                    }
                }else {


                }

            }
        }
        return 0;
    }
}
