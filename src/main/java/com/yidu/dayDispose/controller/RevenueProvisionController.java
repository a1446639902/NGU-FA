package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.pojo.SecuritiesClosedPay;
import com.yidu.businessData.service.CashClosedPayService;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.dayDispose.pojo.BondInterest;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.dayDispose.pojo.TwoFees;
import com.yidu.dayDispose.service.RevenueProvisionService;
import com.yidu.inventoryManage.service.CashClosedPaylnventoryService;
import com.yidu.util.DbUtil;
import com.yidu.util.JsonUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("RevenueProvision")
public class RevenueProvisionController {
    @Resource
    RevenueProvisionService revenueProvisionService;
    @Resource
    com.yidu.businessData.service.CashClosedPayService cashClosedPayService;
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;
    @Resource
    DbUtil dbUtil;

    @RequestMapping("selectRevenueProvision")
    public HashMap selectRevenueProvision(int page, int limit,String statDate){
        HashMap hashMap = revenueProvisionService.selectRevenueProvision(page, limit,statDate);
        int count = (int)hashMap.get("p_count");
        List<RevenueProvision> revenueProvisionList = (List<RevenueProvision>)hashMap.get("p_cursor");
        System.out.println(revenueProvisionList);
        HashMap revenueProvisionMap = new HashMap();
        revenueProvisionMap.put("code",0);
        revenueProvisionMap.put("count",count);
        revenueProvisionMap.put("msg","");
        revenueProvisionMap.put("data",revenueProvisionList);
        return revenueProvisionMap;
    }
    @RequestMapping("selectBondInterest")
    public HashMap selectBondInterest(int page ,int limit,String statDate){
        System.out.println("第二个"+statDate);
        HashMap hashMap = revenueProvisionService.selectBondInterest(page, limit ,statDate);
        int count = (int)hashMap.get("p_count");
        List<BondInterest> bondInterestList = (List<BondInterest>)hashMap.get("p_cursor");
        System.out.println(bondInterestList);
        HashMap bondInterestMap = new HashMap();
        bondInterestMap.put("code",0);
        bondInterestMap.put("count",count);
        bondInterestMap.put("msg","");
        bondInterestMap.put("data",bondInterestList);
        return bondInterestMap;
    }
    @RequestMapping("selectTwoFees")
    public HashMap selectTwoFees(int page, int limit ,String statDate){
        HashMap hashMap = revenueProvisionService.selectTwoFees(page, limit, statDate);
        System.out.println(statDate+"=============================");
        int count = (int)hashMap.get("p_count");
        List<TwoFees> twoFeesList = (List<TwoFees>)hashMap.get("p_cursor");
        System.out.println(twoFeesList);
        HashMap twoFeesMap = new HashMap();
        twoFeesMap.put("code",0);
        twoFeesMap.put("count",count);
        twoFeesMap.put("msg","");
        twoFeesMap.put("data",twoFeesList);
        return twoFeesMap;
    }
    @RequestMapping("CountingCash")
    public int CountingCash(String cash){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(cash);
        List<RevenueProvision> revenueProvisionList = JsonUtil.jsonToArrayList(cash, RevenueProvision.class);
        CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
        for (RevenueProvision revenueProvision : revenueProvisionList) {
            cashClosedPayPojo.setDateTime(revenueProvision.getDateTime());
            cashClosedPayPojo.setFundId(revenueProvision.getFundId());
            cashClosedPayPojo.setAccountId(revenueProvision.getAccountId());
            cashClosedPayService.deleteNew(cashClosedPayPojo);

            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
            cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
            cashClosedPayPojo.setFundId(revenueProvision.getFundId());
            cashClosedPayPojo.setAccountId(revenueProvision.getAccountId());
            cashClosedPayPojo.setServiceType(1);
            cashClosedPayPojo.setAmount(revenueProvision.getCashBlance());
            cashClosedPayPojo.setDateTime(revenueProvision.getDateTime());
            cashClosedPayPojo.setFlag(1);
            i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo);

        }
//        JSONArray jsonArray = JSONArray.fromObject(cash);
//        System.out.println(jsonArray);
//        List list = (List)JSONArray.toCollection(jsonArray, RevenueProvision.class);
//        for (Object o : list) {
//            Iterator it = list.iterator();
//            while(it.hasNext()){
//                RevenueProvision p = (RevenueProvision)it.next();
//                System.out.println(p);
//                cashClosedPayService.deleteNew(p);
//                String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
//                CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
//                cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
//                cashClosedPayPojo.setFundId(p.getFundId());
//                cashClosedPayPojo.setAccountId(p.getAccountId());
//                cashClosedPayPojo.setServiceType(1);
//                cashClosedPayPojo.setAmount(p.getCashBlance());
//                cashClosedPayPojo.setDateTime(p.getDateTime());
//                cashClosedPayPojo.setFlag(1);
//                System.out.println(cashClosedPayPojo);
//                i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo);
//            }
//        }
        return i;
    }
    @RequestMapping("StatisticalSecurities")
    public int StatisticalSecurities(String Securities){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(Securities);
        List<BondInterest> bondInterestList = JsonUtil.jsonToArrayList(Securities, BondInterest.class);
        for (BondInterest bondInterest : bondInterestList) {
            System.out.println(bondInterest.getAccountId());
            SecuritiesClosedPay securitiesClosedPay = new SecuritiesClosedPay();
            securitiesClosedPay.setDateTime(bondInterest.getDateTime());
            securitiesClosedPay.setFundId(bondInterest.getFundId());
            securitiesClosedPay.setSecuritiesId(bondInterest.getSecuritiesId());
            securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPay);
            SecuritiesClosedPay securitiesClosedPay1 = new SecuritiesClosedPay();
            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP);
            System.out.println(cashClosedPayId);
            securitiesClosedPay1.setSecuritiesClosedPayId(cashClosedPayId);
            securitiesClosedPay1.setFundId(bondInterest.getFundId());
            securitiesClosedPay1.setAccountId(bondInterest.getAccountId());
            securitiesClosedPay1.setServiceType(1);
            securitiesClosedPay1.setAmount(bondInterest.getSecuritiesNum()*bondInterest.getBondRateAmount());
            securitiesClosedPay1.setDateTime(bondInterest.getDateTime());
            securitiesClosedPay1.setFlag(1);
            securitiesClosedPay1.setSecuritiesId(bondInterest.getSecuritiesId());
            i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay1);
        }
        return i;
    }
    @RequestMapping("StatisticalTwoFees")
    public int statisticalTwoFees(String TwoFees){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(TwoFees);
        List<TwoFees> twoFeesList = JsonUtil.jsonToArrayList(TwoFees, TwoFees.class);
        for (TwoFees twoFees: twoFeesList) {
            CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
            cashClosedPayPojo.setDateTime(twoFees.getValueStatisticsDate());
            cashClosedPayPojo.setFundId(twoFees.getFundId());
            cashClosedPayPojo.setAccountId(twoFees.getAccountId());
            cashClosedPayService.deleteNew(cashClosedPayPojo);

            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
            cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
            cashClosedPayPojo.setFundId(twoFees.getFundId());
            cashClosedPayPojo.setAccountId(twoFees.getAccountId());
            cashClosedPayPojo.setServiceType(1);
            cashClosedPayPojo.setAmount(twoFees.getPropertyNetWorth());
            cashClosedPayPojo.setDateTime(twoFees.getValueStatisticsDate());
            cashClosedPayPojo.setFlag(1);
            i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo);

        }
        return i;
    }
    
}
