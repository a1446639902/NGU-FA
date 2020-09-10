package com.yidu.businessDispose.controller;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessDispose.pojo.Settlement;
import com.yidu.businessDispose.service.SettlementService;
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
        @RequestMapping("/selectSettlement")
        public HashMap selectSettlement(int page, int limit,String status,String dateTime,String transactionDataMode){
            HashMap hashMap = settlementService.selectSettlement(page,limit,status,dateTime,transactionDataMode);
            int count = (int) hashMap.get("p_count");
            List<Settlement> settlementList = (List<Settlement>) hashMap.get("p_cursor");
            System.out.println("总条数："+count);
            System.out.println("page="+page+",limit="+limit+",status="+status+",dateTime="+dateTime+",transactionDataMode="+transactionDataMode);

            HashMap settMap = new HashMap();
            settMap.put("count",count);
            settMap.put("code",0);
            settMap.put("msg","");
            settMap.put("data", settlementList);
            System.out.println("shuju"+ settlementList);
            System.out.println("交易："+ settlementList.size());
            return settMap;

        }
        @RequestMapping("/insertSettlement")
        public int insertSettlement(Settlement settlement, HttpServletRequest request){
            settlement.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
            settlement.setFundId(GetFundIdUtil.getFundId(request));
            System.out.println(settlement);
            return settlementService.insertSettlement(settlement);
        }

        @RequestMapping("/deleteTransactionData")
        public int deleteTransactionData(String transactionDataId){
            return settlementService.deleteSettlement(transactionDataId);
        }

        @RequestMapping("/updateSettlement")
        public int updateTransactionData(String transactionDataIds,String status){
            return settlementService.updateSettlement(transactionDataIds,status);
        }
    }
