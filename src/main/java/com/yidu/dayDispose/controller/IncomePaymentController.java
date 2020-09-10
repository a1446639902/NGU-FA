package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.service.CashClosedPayService;
import com.yidu.dayDispose.pojo.IncomePaymentPojo;
import com.yidu.dayDispose.service.IncomePaymentService;
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

    @RequestMapping("selectCashClosedPays")
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
    @RequestMapping("selectSecuritiesClosedPay")
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

    @RequestMapping("selectTwoCost")
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
}
