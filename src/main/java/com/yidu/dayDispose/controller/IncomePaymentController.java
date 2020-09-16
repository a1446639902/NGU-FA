package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.CashClosedPayService;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.cashControl.service.BankTreasurerService;
import com.yidu.dayDispose.pojo.IncomePaymentPojo;
import com.yidu.dayDispose.service.IncomePaymentService;
import com.yidu.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName IncomePaymentController
 * @Description: TODO
 * @Author 硠君
 * @Date create in 16:33 2020/9/9
 * @Version 1.0
 **/
@RestController
public class IncomePaymentController {
    @Resource
    IncomePaymentService incomePaymentService;
    @Resource
    CashClosedPayService cashClosedPayService;
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;
    @Resource
    BankTreasurerService bankTreasurerService;
    @Resource
    DbUtil dbUtil;

    @RequestMapping("selectCashClosedPays")//在现金应收应付库存查询相应存款计息信息
    public Map<String,Object> selectCashClosedPays(String page, String limit,  String businessDate,HttpServletRequest request){
        System.out.println("进入了IncomePayment现金支付查询Controller");
        System.out.println("现金控制层传回的日期:="+businessDate);
        //调用Service层 返回结果集map
        Map<String,Object> map =incomePaymentService.selectCashClosedPays(limit,page,businessDate,request);
        //从结果集中拿出结果
        //接收返回数据
        List<IncomePaymentPojo> IncomePayments= (List<IncomePaymentPojo>) map.get("IncomePayments");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",IncomePayments);
        //返回数据
        return json;
    }

    @RequestMapping("selectSecuritiesClosedPay")//在证券应收应付库存查询相应债券计息信息
    public Map<String,Object> selectSecuritiesClosedPay(String page, String limit,  String businessDate,HttpServletRequest request){
        System.out.println("进入了IncomePayment证券支付查询Controller");
        System.out.println("证券控制层传回的日期:="+businessDate);
        //调用Service层 返回结果集map
        Map<String,Object> map =incomePaymentService.selectSecuritiesClosedPay(limit,page,businessDate,request);
        //从结果集中拿出结果
        //接收返回数据
        List<IncomePaymentPojo> IncomePayments= (List<IncomePaymentPojo>) map.get("IncomePayments");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",IncomePayments);
        //返回数据
        return json;
    }

    @RequestMapping("selectTwoCost")//在现金应收应付库存查询相应两费
    public Map<String,Object> selectTwoCost(String page, String limit,  String businessDate,HttpServletRequest request){
        System.out.println("进入了IncomePayment两费支付查询Controller");
        System.out.println("两费控制层传回的日期:="+businessDate);
        //调用Service层 返回结果集map
        Map<String,Object> map =incomePaymentService.selectTwoCost(limit,page,businessDate,request);
        //从结果集中拿出结果
        //接收返回数据
        List<IncomePaymentPojo> IncomePayments= (List<IncomePaymentPojo>) map.get("IncomePayments");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",IncomePayments);
        //返回数据
        return json;
    }
//现金计息与两费的先删后增
    @RequestMapping("testCash")
    public int testCash(String cash,HttpServletRequest request){
        int i=0;
        List<IncomePaymentPojo> cashList = JsonUtil.jsonToArrayList(cash, IncomePaymentPojo.class);
        for (IncomePaymentPojo income: cashList) {
            Map map=new HashMap();
            map.put("fundId", GetFundIdUtil.getFundId(request));
            map.put("serviceType",income.getBusinessType());
            map.put("dateTime",income.getBusinessDate());
            map.put("flag",income.getBusinessStatus()*-1);
            String cashClosedPayId1 = cashClosedPayService.selectCashClosedPayId(map);
//资金调拨的删除
            bankTreasurerService.deleteBankTreasurerByBusinessId(cashClosedPayId1);
//现金应收应付的删除
            cashClosedPayService.deleteCashClosedPay(cashClosedPayId1);
//现金应收应付的新增
            String cashClosedPayId2 = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
            CashClosedPayPojo cashClosedPayPojo=new CashClosedPayPojo();
            cashClosedPayPojo.setCashClosedPayId(cashClosedPayId2);
            cashClosedPayPojo.setFundId(GetFundIdUtil.getFundId(request)) ;
            cashClosedPayPojo.setAccountId(income.getAccountId());
            cashClosedPayPojo.setServiceType(income.getBusinessType());
            cashClosedPayPojo.setAmount(income.getTotalMoney());
            cashClosedPayPojo.setDateTime(income.getBusinessDate());
            cashClosedPayPojo.setFlag(-1*income.getBusinessStatus());
            cashClosedPayService.insertCashClosedPay(cashClosedPayPojo,request);
//资金调拨的新增
            String bankTreasurerId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT);
            BankTreasurerPojo bankTreasurerPojo=new BankTreasurerPojo();
            bankTreasurerPojo.setBankTreasurerId(bankTreasurerId);
            bankTreasurerPojo.setFundId(GetFundIdUtil.getFundId(request));
            bankTreasurerPojo.setTotalPrice(income.getTotalMoney());
            bankTreasurerPojo.setAccountId(income.getAccountId());
            bankTreasurerPojo.setFlag(income.getBusinessStatus());
            bankTreasurerPojo.setDbTime(income.getBusinessDate());
            bankTreasurerPojo.setDateTime(income.getBusinessDate());
            bankTreasurerPojo.setBusinessId(cashClosedPayId2);
            if (income.getBusinessType()==3){
                bankTreasurerPojo.setAllocatingType(1);
            }else if (income.getBusinessType()==1 || income.getBusinessType()==2){
                bankTreasurerPojo.setAllocatingType(6);
            }
            bankTreasurerPojo.setBankTreasurerDesc("");
            i = bankTreasurerService.insertBankTreasurer(bankTreasurerPojo);
        }
        return i;
    };
//    债券计息的先删后增
    @RequestMapping("testBond")
    public int testBond(String bond,HttpServletRequest request){
        int i=0;
        List<IncomePaymentPojo> bondList = JsonUtil.jsonToArrayList(bond, IncomePaymentPojo.class);
        for (IncomePaymentPojo income: bondList) {
            Map map=new HashMap();
            map.put("fundId", GetFundIdUtil.getFundId(request));
            map.put("serviceType",income.getSecuritiesType());
            map.put("dateTime",income.getBusinessDate());
            map.put("flag",income.getBusinessStatus()*-1);
            System.out.println("查询应收应付编号：" + "查询的条件是：" + map);
            String securitiesClosedPayId = securitiesClosedPayService.selectSecuritiesClosedPayId(map);
//资金调拨的删除
            bankTreasurerService.deleteBankTreasurerByBusinessId(securitiesClosedPayId);
//现金应收应付的删除
            securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPayId);
//现金应收应付的新增
            String  securitiesClosedPayId2= dbUtil.requestDbTableMaxId(SysTableNameListUtil.SCP);
            SecuritiesClosedPayPojo securitiesClosedPayPojo=new SecuritiesClosedPayPojo();
            securitiesClosedPayPojo.setSecuritiesClosedPayId(securitiesClosedPayId2);
           securitiesClosedPayPojo.setFundId(GetFundIdUtil.getFundId(request));
            securitiesClosedPayPojo.setAccountId(GetAccountUtil.getAccountId(request));
            securitiesClosedPayPojo.setSecuritiesId(income.getSecuritiesId());
            securitiesClosedPayPojo.setServiceType(income.getSecuritiesType());
            securitiesClosedPayPojo.setAmount(income.getTotalMoney());
            securitiesClosedPayPojo.setDateTime(income.getBusinessDate());
            securitiesClosedPayPojo.setFlag(income.getBusinessStatus()*-1);
            securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPayPojo);
//资金调拨的新增
           String bankTreasurerId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT);
            BankTreasurerPojo bankTreasurerPojo=new BankTreasurerPojo();
            bankTreasurerPojo.setBankTreasurerId(bankTreasurerId);
            bankTreasurerPojo.setFundId(GetFundIdUtil.getFundId(request));
            bankTreasurerPojo.setTotalPrice(income.getTotalMoney());
            bankTreasurerPojo.setAccountId(GetAccountUtil.getAccountId(request));
            bankTreasurerPojo.setFlag(income.getBusinessStatus());
            bankTreasurerPojo.setDbTime(income.getBusinessDate());
            bankTreasurerPojo.setDateTime(income.getBusinessDate());
            bankTreasurerPojo.setBusinessId(securitiesClosedPayId2);
            bankTreasurerPojo.setAllocatingType(4);
            bankTreasurerPojo.setBankTreasurerDesc("");
            i = bankTreasurerService.insertBankTreasurer(bankTreasurerPojo);
        }
        return i;
    };
}
