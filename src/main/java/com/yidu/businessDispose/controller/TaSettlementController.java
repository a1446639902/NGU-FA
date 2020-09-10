package com.yidu.businessDispose.controller;

import com.yidu.businessDispose.pojo.TaSettlement;
import com.yidu.businessDispose.service.TaSettlementService;
import com.yidu.businessParameter.pojo.Bond;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TA结算表
 * @Type 控制层
 * @author 唐赈环
 * @version 1.2
 * @time 2020/9/9
 **/
@RestController
@RequestMapping("TaSettlement")
public class TaSettlementController {
    @Resource
    TaSettlementService taSettlementService;
    @Resource
    DbUtil dbUtil;
    @RequestMapping("selectTaSettlement")
    public Map<String, Object> selectTaSettlement(String limit,String page,String dateTime,String transactionType,String status) {
        System.out.println("进来查询了" + status);
        Map<String,Object> map=taSettlementService.selectTaSettlement(limit,page,dateTime,transactionType,status);
        List<TaSettlement> taSettlementList= (List<TaSettlement>) map.get("taSettlementList");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",taSettlementList);
        /*System.out.println("结果集+"+taSettlementList)*/;

        //返回数据
        return json;
    }
    @RequestMapping("/deleteTaSettlement")
    public void deleteTaSettlement(String dateTime){
        System.out.println("进来了！");
        taSettlementService.deleteTaSettlement(dateTime);
    }
    @RequestMapping("/updateTaSettlement")
    public int updateTaSettlement(String taTransactionIds,String status){
        System.out.println("进来了!:");
        System.out.println("修改时:" + taTransactionIds);
        int b = taSettlementService.updateTaSettlement(taTransactionIds,status);
        return  b;
    }
    @RequestMapping("/insertTaSettlement")
    public int insertTaSettlement(TaSettlement taSettlement){
        taSettlement.setDateTime(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TT));
        taSettlement.setFundId("60001");
        System.out.println("taSettlement=" + taSettlement);
        int i = taSettlementService.insertTaSettlement(taSettlement);
        return i;
    }
}


