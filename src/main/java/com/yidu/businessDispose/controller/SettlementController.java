package com.yidu.businessDispose.controller;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessDispose.pojo.Settlement;
import com.yidu.businessDispose.service.SettlementService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.DbUtil;
import com.yidu.util.GetFundIdUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author Tmac
 * @version 1.0
 * @time 2020/9/8  11:34
 **/
@RestController

@RequestMapping("/Settlement")
public class SettlementController {
        @Resource
        SettlementService settlementService;

        @Resource
        DbUtil dbUtil;
        @NGULog(message = "查询交易结算表")
        @RequestMapping("/selectSettlement")
        public HashMap selectSettlement(int page, int limit,String status,String dateTime,String transactionDataMode){
            //调用service方法传值
            HashMap hashMap = settlementService.selectSettlement(page,limit,status,dateTime,transactionDataMode);
            //通过hashMap获取p_count总条数
            int count = (int) hashMap.get("p_count");
            //通过hashMap获取p_cursor游标数据返回集合,强转下类型
            List<Settlement> settlementList = (List<Settlement>) hashMap.get("p_cursor");
            //创建一个HashMap
            HashMap settMap = new HashMap();
            //给状态码赋值count,code,msg,data
            settMap.put("count",count);
            settMap.put("code",0);
            settMap.put("msg","");
            settMap.put("data", settlementList);
            return settMap;

        }
        @NGULog(message = "查添加交易结算表")
        @RequestMapping("/insertSettlement")
        public int insertSettlement(Settlement settlement, HttpServletRequest request){
            //给交易数据id进行赋值
            settlement.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
            //给基金id进行赋值
            settlement.setFundId(GetFundIdUtil.getFundId(request));
            return settlementService.insertSettlement(settlement);
        }
        @NGULog(message = "删除交易结算表")
        @RequestMapping("/deleteTransactionData")
        public int deleteTransactionData(String transactionDataId){
            return settlementService.deleteSettlement(transactionDataId);
        }

        @NGULog(message = "修改状态交易未结算表")
        @RequestMapping("/updateSettlement")
        public int updateTransactionData(String settlement){
            return settlementService.updateSettlement(settlement);
        }

        @NGULog(message = "修改状态交易已结算表")
        @RequestMapping("/updateTwoSettlement")
        public int updateTwoTransactionData(String settlement){
            return settlementService.updateSettlementTwo(settlement);
        }
    }
