package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.service.CashClosedPayService;
import com.yidu.businessParameter.pojo.VarietiesRatePojo;
import com.yidu.dayDispose.pojo.RevenueProvision;
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
 * @ClassName CashClosedPayController
 * @Description: TODO
 * @Author 硠君
 * @Date create in 9:53 2020/9/4
 * @Version 1.0
 **/
@RestController
public class CashClosedPayController {
    @Resource
    CashClosedPayService cashClosedPayService;

    @RequestMapping("insertCashClosedPay")
    public int insertCashClosedPay(CashClosedPayPojo cashClosedPay,HttpServletRequest request){
        System.out.println("进入了cashClosedPay新增Controller");
        int i = cashClosedPayService.insertCashClosedPay(cashClosedPay,request);
        return i;
    };
    @RequestMapping("deleteCashClosedPay")
    public int deleteCashClosedPay(String cashClosedPayId){
        System.out.println("进入了cashClosedPay删除Controller");
        int i = cashClosedPayService.deleteCashClosedPay(cashClosedPayId);
        return i;
    };
    @RequestMapping("updateCashClosedPay")
    public int updateCashClosedPay(CashClosedPayPojo cashClosePay){
        System.out.println("进入了cashClosedPay修改Controller");
        int i = cashClosedPayService.updateCashClosedPay(cashClosePay);
        return i;
    };
    @RequestMapping("selectCashClosedPay")
    public Map<String,Object> selectCashClosedPay(String page, String limit,String dateTime,String serviceType){
        System.out.println("进入了cashClosedPay查询Controller");
        //调用Service层 返回结果集map
        Map<String,Object> map =cashClosedPayService.selectCashClosedPay(limit,page,dateTime,serviceType);
        //从结果集中拿出结果
        //接收返回数据
        List<CashClosedPayPojo> cashClosedPays= (List<CashClosedPayPojo>) map.get("cashClosedPays");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",cashClosedPays);
        //返回数据
        return json;
    };
    @RequestMapping("deleteNew")
   public int deleteNew(CashClosedPayPojo cashClosedPay){
        int i = cashClosedPayService.deleteNew(cashClosedPay);
        return i;
    }

}
