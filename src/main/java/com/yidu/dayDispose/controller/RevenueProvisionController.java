package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.dayDispose.pojo.BondInterest;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.dayDispose.pojo.TwoFees;
import com.yidu.dayDispose.service.RevenueProvisionService;
import com.yidu.permission.aspect.NGULog;
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
    @NGULog(message = "查询现金账户join现金库存")
    @RequestMapping("selectRevenueProvision")
   // int page, int limit,String statDate  page 页码 limit 每页条数  statDate  前端传的日期 查询条件
    public HashMap selectRevenueProvision(int page, int limit,String statDate){
        HashMap hashMap = revenueProvisionService.selectRevenueProvision(page, limit,statDate);
        // 通过(int)hashMap.get("p_count")获得count条数
        int count = (int)hashMap.get("p_count");
        //通过(List<RevenueProvision>)hashMap.get("p_cursor") 获得RevenueProvision类型的集合
        List<RevenueProvision> revenueProvisionList = (List<RevenueProvision>)hashMap.get("p_cursor");
        System.out.println(revenueProvisionList);
        //返回集合数据到前端
        HashMap revenueProvisionMap = new HashMap();
        revenueProvisionMap.put("code",0);
        revenueProvisionMap.put("count",count);
        revenueProvisionMap.put("msg","");
        revenueProvisionMap.put("data",revenueProvisionList);
        return revenueProvisionMap;
    }
    //查询债券利息
    @NGULog(message = "证券库存join债券信息")
    @RequestMapping("selectBondInterest")
    public HashMap selectBondInterest(int page ,int limit,String statDate){
        System.out.println("第二个"+statDate);
        HashMap hashMap = revenueProvisionService.selectBondInterest(page, limit ,statDate);
        // 通过(int)hashMap.get("p_count")获得count条数
        int count = (int)hashMap.get("p_count");
        //通过(List<BondInterest>)hashMap.get("p_cursor");获得BondInterest类型的集合
        List<BondInterest> bondInterestList = (List<BondInterest>)hashMap.get("p_cursor");
        System.out.println(bondInterestList);
        //返回bondInterestMap 集合到前端
        HashMap bondInterestMap = new HashMap();
        bondInterestMap.put("code",0);
        bondInterestMap.put("count",count);
        bondInterestMap.put("msg","");
        bondInterestMap.put("data",bondInterestList);
        return bondInterestMap;
    }
    @NGULog(message = "净值统计join基金信息")
    @RequestMapping("selectTwoFees")
    public HashMap selectTwoFees(int page, int limit ,String statDate){

        HashMap hashMap = revenueProvisionService.selectTwoFees(page, limit, statDate);
        System.out.println(statDate+"=============================");
        // 通过(int)hashMap.get("p_count")获得count条数
        int count = (int)hashMap.get("p_count");
        //通过(List<TwoFees>)hashMap.get("p_cursor"); 获得TwoFees类型的集合
        List<TwoFees> twoFeesList = (List<TwoFees>)hashMap.get("p_cursor");
        System.out.println(twoFeesList);
        HashMap twoFeesMap = new HashMap();
        twoFeesMap.put("code",0);
        twoFeesMap.put("count",count);
        twoFeesMap.put("msg","");
        twoFeesMap.put("data",twoFeesList);
        return twoFeesMap;
    }

    @NGULog(message = "现金信息页面选中信息")
    @RequestMapping("CountingCash")
    //String cash,HttpServletRequest request cash是前端返回的json对象字符串
    public int CountingCash(String cash,HttpServletRequest request){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(cash);
        //通过调用sonUtil.jsonToArrayList(cash, RevenueProvision.class);工具类得到RevenueProvision类型的集合
        List<RevenueProvision> revenueProvisionList = JsonUtil.jsonToArrayList(cash, RevenueProvision.class);
        CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
        //遍历集合
        for (RevenueProvision revenueProvision : revenueProvisionList) {
            //setDateTime 放时间
            cashClosedPayPojo.setDateTime(revenueProvision.getDateTime());
            //setFundId  放基金Id
            cashClosedPayPojo.setFundId(revenueProvision.getFundId());
            //setAccountId 账户Id
            cashClosedPayPojo.setAccountId(revenueProvision.getAccountId());
            //dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP) 通过工具类获得最大Id
                String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);

                cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
//                cashClosedPayPojo.setFundId(revenueProvision.getFundId());
//                cashClosedPayPojo.setAccountId(revenueProvision.getAccountId());
            //setServiceType 类型为3
                cashClosedPayPojo.setServiceType(3);
                //.setAmount 放入利息  getInterest get利息
                cashClosedPayPojo.setAmount(revenueProvision.getInterest());
                System.out.println(revenueProvision.getInterest());
//                cashClosedPayPojo.setDateTime(revenueProvision.getDateTime());
                cashClosedPayPojo.setFlag(1);
                i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
                if(i>0){
                    i=cashClosedPayService.deleteNew(cashClosedPayPojo);
                    if(i>0){
                        i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
                        System.out.println("这是现金应收应付先删后增的i"+i);
                    }
                }

        }

        return i;
    }

    @NGULog(message = "债券信息页面选中信息")
    @RequestMapping("StatisticalSecurities")
    public int StatisticalSecurities(String Securities,HttpServletRequest request){
        int i=0;

        System.out.println(Securities);
        //从session获得accountId  GetAccountUtil.getAccountId(request);
        String accountId = GetAccountUtil.getAccountId(request);
        System.out.println("进来了==============================================="+accountId);
        List<BondInterest> bondInterestList = JsonUtil.jsonToArrayList(Securities, BondInterest.class);
        for (BondInterest bondInterest : bondInterestList) {
            System.out.println(bondInterest.getAccountId()+"这是getAccountId======================================");
            //创建SecuritiesClosedPayPojo实体类
            SecuritiesClosedPayPojo securitiesClosedPay1 = new SecuritiesClosedPayPojo();
            dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP);//获得最大ID
            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP);
            System.out.println(cashClosedPayId);
            //放入setSecuritiesClosedPayId(cashClosedPayId);
            securitiesClosedPay1.setSecuritiesClosedPayId(cashClosedPayId);
            //setFundId(bondInterest.getFundId());
            securitiesClosedPay1.setFundId(bondInterest.getFundId());
            //securitiesClosedPay1.setAccountId(accountId);
            securitiesClosedPay1.setAccountId(accountId);
            //setServiceType(3);
            securitiesClosedPay1.setServiceType(3);
            //setAmount(bondInterest.getInterest());
            //Amount是现金应收应付表的利息  Interest是债券信息算出的利息
            securitiesClosedPay1.setAmount(bondInterest.getInterest());
            //setDateTime
            securitiesClosedPay1.setDateTime(bondInterest.getDateTime());
            //setFlag(1);
            securitiesClosedPay1.setFlag(1);
            //证券Id
            securitiesClosedPay1.setSecuritiesId(bondInterest.getSecuritiesId());
            System.out.println(securitiesClosedPay1);
            //先增
            i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay1);
            System.out.println(i+"插入证券应收应付的I===========================");
            if(i>0){
                //删
                i = securitiesClosedPayService.deleteSecuritiesClosedPayByPojo(securitiesClosedPay1);
                if(i>0){
                    //再增
                    i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay1);
                }
            }

        }
        return i;
    }
    @NGULog(message = "两费信息页面选中信息")
    @RequestMapping("StatisticalTwoFees")
    //前端返回的json字符串名字TwoFees  String TwoFees, HttpServletRequest request
    public int statisticalTwoFees(String TwoFees, HttpServletRequest request){
        int i=0;
        System.out.println("进来了===============================================");
        System.out.println(TwoFees);
        //通过JsonUtil.jsonToArrayList(TwoFees, TwoFees.class); 得到twoFeesList类型的集合
        List<TwoFees> twoFeesList = JsonUtil.jsonToArrayList(TwoFees, TwoFees.class);
        for (TwoFees twoFees: twoFeesList) {
            //如果是第一次查询现金应收应付没有数据，先增加
            System.out.println(twoFees+"===================================================");
            CashClosedPayPojo cashClosedPayPojo = new CashClosedPayPojo();
            //dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);获得最大ID
            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
            //setCashClosedPayId
            cashClosedPayPojo.setCashClosedPayId(cashClosedPayId);
            //setFundId
            cashClosedPayPojo.setFundId(twoFees.getFundId());
            //setAccountId
            cashClosedPayPojo.setAccountId(twoFees.getAccountId());
            //setServiceType(1);
            cashClosedPayPojo.setServiceType(1);
            //setAmount(twoFees.getManagementMoney());  数据库字段名不一样
            cashClosedPayPojo.setAmount(twoFees.getManagementMoney()*(-1));
            //setDateTime(twoFees.getValueStatisticsDate()); 数据库字段名不一样
            cashClosedPayPojo.setDateTime(twoFees.getValueStatisticsDate());
            //setFlag 状态-1 流出
            cashClosedPayPojo.setFlag(-1);

            //增加管理费利息数据
            int i1=cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
            if (i1>0){
                i1=cashClosedPayService.deleteNew(cashClosedPayPojo);
                if(i1>0){
                    cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
                }
            }
            //增加托管费利息数据
            cashClosedPayPojo.setServiceType(2);
            double custodyMoney = twoFees.getCustodyMoney();
            //setAmount getCustodyMoney 流出金额*-1
            cashClosedPayPojo.setAmount(custodyMoney*(-1));
            //增
            i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
            if(i>0){
                //删
                i = cashClosedPayService.deleteNew(cashClosedPayPojo);
                if(i>0){
                    //增
                    i = cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
                }
            }

        }
        return i;
    }
    
}
