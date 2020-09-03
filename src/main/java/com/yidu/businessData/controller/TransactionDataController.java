package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 交易数据表
 * @Type:控制层
 * @author Tmac
 * @time 2020/9/1  15:06
 * @version   1.0
 **/
@RestController
@RequestMapping("/TransactionData")
public class TransactionDataController {
    @Resource
    TransactionDataService transactionDataService;
    @RequestMapping("/selectTransactionData")
    public HashMap selectTransactionData(){
        List<TransactionData> transactionDataList = transactionDataService.selectTransactionData();
        HashMap transactionDataMap = new HashMap();
        transactionDataMap.put("count",10);
        transactionDataMap.put("code",0);
        transactionDataMap.put("msg","");
        transactionDataMap.put("data",transactionDataList);
        System.out.println("基金大小"+transactionDataList.size());
        return transactionDataMap;
    }
    @RequestMapping("/insertTransactionData")
    public int insertTransactionData(TransactionData transactionData){
       return transactionDataService.insertTransactionData(transactionData);
    }

    @RequestMapping("/deleteTransactionData")
    public int deleteTransactionData(int tradeId){
        return transactionDataService.deleteTransactionData(tradeId);
    }

    @RequestMapping("/updateTransactionData")
    public int updateTransactionData(TransactionData transactionData){
        return transactionDataService.updateTransactionData(transactionData);
    }
}
