package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.dayDispose.pojo.BondInterest;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.dayDispose.pojo.TwoFees;
import com.yidu.dayDispose.service.RevenueProvisionService;
import com.yidu.util.DbUtil;
import com.yidu.util.GetAccountUtil;
import com.yidu.util.JsonUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
     static double custodyMoney;
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
    //查询债券利息
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
    public int CountingCash(String cash,HttpServletRequest request){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(cash);
        List<RevenueProvision> revenueProvisionList = JsonUtil.jsonToArrayList(cash, RevenueProvision.class);
        CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
        for (RevenueProvision revenueProvision : revenueProvisionList) {
            cashClosedPayPojo.setDateTime(revenueProvision.getDateTime());
            cashClosedPayPojo.setFundId(revenueProvision.getFundId());
            cashClosedPayPojo.setAccountId(revenueProvision.getAccountId());
            System.out.println(cashClosedPayPojo+"===============================================");
            i=cashClosedPayService.deleteNew(cashClosedPayPojo);
            if(i>0){
                String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
                cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
                cashClosedPayPojo.setFundId(revenueProvision.getFundId());
                cashClosedPayPojo.setAccountId(revenueProvision.getAccountId());
                cashClosedPayPojo.setServiceType(3);
                cashClosedPayPojo.setAmount(revenueProvision.getInterest());
                System.out.println(revenueProvision.getInterest());
                cashClosedPayPojo.setDateTime(revenueProvision.getDateTime());
                cashClosedPayPojo.setFlag(1);
                i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
            }



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
    public int StatisticalSecurities(String Securities,HttpServletRequest request){
        int i=0;

        System.out.println(Securities);
        String accountId = GetAccountUtil.getAccountId(request);
        System.out.println("进来了==============================================="+accountId);
        List<BondInterest> bondInterestList = JsonUtil.jsonToArrayList(Securities, BondInterest.class);
        for (BondInterest bondInterest : bondInterestList) {
            System.out.println(bondInterest.getAccountId()+"这是getAccountId======================================");
            SecuritiesClosedPayPojo securitiesClosedPay1 = new SecuritiesClosedPayPojo();
            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP);
            System.out.println(cashClosedPayId);
            securitiesClosedPay1.setSecuritiesClosedPayId(cashClosedPayId);
            securitiesClosedPay1.setFundId(bondInterest.getFundId());
            securitiesClosedPay1.setAccountId(accountId);
            securitiesClosedPay1.setServiceType(3);
            securitiesClosedPay1.setAmount(bondInterest.getInterest());
            securitiesClosedPay1.setDateTime(bondInterest.getDateTime());
            securitiesClosedPay1.setFlag(1);
            securitiesClosedPay1.setSecuritiesId(bondInterest.getSecuritiesId());
            System.out.println(securitiesClosedPay1);
            i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay1);
            System.out.println(i+"插入证券应收应付的I===========================");
            SecuritiesClosedPayPojo securitiesClosedPay = new SecuritiesClosedPayPojo();
            securitiesClosedPay.setDateTime(bondInterest.getDateTime());
            securitiesClosedPay.setFundId(bondInterest.getFundId());
            securitiesClosedPay.setSecuritiesId(bondInterest.getSecuritiesId());
            System.out.println(securitiesClosedPay);
            i = securitiesClosedPayService.deleteSecuritiesClosedPayByPojo(securitiesClosedPay);
             if(i>0){
                 System.out.println(i+"===================================这是一个删除证券应收应付的结果");
                 String cashClosedPayId1 = dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP);
                 System.out.println(cashClosedPayId1);
                 securitiesClosedPay1.setSecuritiesClosedPayId(cashClosedPayId1);
                 securitiesClosedPay1.setFundId(bondInterest.getFundId());
                 securitiesClosedPay1.setAccountId(accountId);
                 securitiesClosedPay1.setServiceType(3);
                 securitiesClosedPay1.setAmount(bondInterest.getInterest());
                 securitiesClosedPay1.setDateTime(bondInterest.getDateTime());
                 securitiesClosedPay1.setFlag(1);
                 securitiesClosedPay1.setSecuritiesId(bondInterest.getSecuritiesId());
                 System.out.println(securitiesClosedPay1);
                 i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay1);
                 System.out.println(i+"插入证券应收应付的I===========================");
             }

        }
        return i;
    }
    @RequestMapping("StatisticalTwoFees")
    public int statisticalTwoFees(String TwoFees, HttpServletRequest request){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(TwoFees);
        List<TwoFees> twoFeesList = JsonUtil.jsonToArrayList(TwoFees, TwoFees.class);
        for (TwoFees twoFees: twoFeesList) {
            //如果是第一次查询现金应收应付没有数据，先增加
            System.out.println(twoFees+"===================================================");
            CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
            cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
            cashClosedPayPojo.setFundId(twoFees.getFundId());
            cashClosedPayPojo.setAccountId(twoFees.getAccountId());
            cashClosedPayPojo.setServiceType(1);
            cashClosedPayPojo.setAmount(twoFees.getManagementMoney());
            cashClosedPayPojo.setDateTime(twoFees.getValueStatisticsDate());
            cashClosedPayPojo.setFlag(1);
            custodyMoney = twoFees.getCustodyMoney();
            System.out.println(custodyMoney+"================================成员变量1");
            //增加管理费利息数据
            cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
            //增加托管费利息数据
            cashClosedPayPojo.setServiceType(2);
            cashClosedPayPojo.setAmount(custodyMoney);
            //按条件删除现金应收应付
            System.out.println("两费========================="+cashClosedPayPojo);
            i = cashClosedPayService.deleteNew(cashClosedPayPojo);
            System.out.println(1+"删除两费的状态=========================");
            if(i>0){
                String cashClosedPayId1 = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
                cashClosedPayPojo.setCashClosedPayId(cashClosedPayId1);
                cashClosedPayPojo.setFundId(twoFees.getFundId());
                cashClosedPayPojo.setAccountId(twoFees.getAccountId());
                cashClosedPayPojo.setServiceType(1);
                cashClosedPayPojo.setAmount(twoFees.getManagementMoney());
                cashClosedPayPojo.setDateTime(twoFees.getValueStatisticsDate());
                cashClosedPayPojo.setFlag(-1);
                i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
                cashClosedPayPojo.setServiceType(2);
                System.out.println(this.custodyMoney+"================================这是成员变量");
                cashClosedPayPojo.setAmount(this.custodyMoney);
                System.out.println(twoFees);
                System.out.println(custodyMoney);
                i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
                System.out.println(i+"这是两费的i====================================");
            }

        }
        return i;
    }
    
}
