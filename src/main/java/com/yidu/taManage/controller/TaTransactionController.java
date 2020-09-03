package com.yidu.taManage.controller;

import com.yidu.businessParameter.pojo.BondPojo;
import com.yidu.taManage.pojo.TaTransactionPojo;
import com.yidu.taManage.service.TaTransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  TA交易数据信息表数的控制器 处理器
 *  @author 唐赈环
 *  @date  2020/09/01 15点32分
 *  @version 版本1.0
 */
@RestController
public class TaTransactionController {
    @Resource
    TaTransactionService tatransactionService;
    @RequestMapping ("/insertTaTransaction")
    public int insertTaTransaction(BondPojo bondpojo){
        System.out.println("进来了");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        String format = formatter.format(date);
        TaTransactionPojo tatransaction=new TaTransactionPojo("1","1","3","4",1.1,"1",1.3,1.4,1.5,1.6,1,1,1);
        int i= tatransactionService.insertTaTransaction(tatransaction);
        System.out.println(i);
        return i;
    }
    @RequestMapping("/deleteTaTransaction")
    public void deleteTaTransaction(){
        System.out.println("进来了");
        tatransactionService.deleteTaTransaction(1);
    }
    @RequestMapping("/updateTaTransaction")
    public int updateTaTransaction(){
        System.out.println("进来了");
        TaTransactionPojo tatransaction1=new TaTransactionPojo("1","1","3","4",1.1,"1",1.3,1.4,1.5,1.6,1,2,3);
        int b = tatransactionService.updateTaTransaction(tatransaction1);
        return b;
    }
    @RequestMapping("/selectTaTransaction")
    public Map<String,Object> selectTaTransaction(String page, String limit) {
        System.out.println("进来了");
        Map<String,Object> map=tatransactionService.selectTaTransaction(limit, page);
        List<TaTransactionPojo> tatransactionList= (List<TaTransactionPojo>) map.get("tatransactionList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",tatransactionList);
        //返回数据
        return json;
    }

}