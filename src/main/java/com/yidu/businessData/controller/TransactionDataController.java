package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
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
 * +-1
 * @version   1.0
 **/
@RestController
@RequestMapping("/TransactionData")
public class TransactionDataController {
    @Resource
    TransactionDataService transactionDataService;

    @Resource
    DbUtil dbUtil;
    @RequestMapping("/selectTransactionData")
    public HashMap selectTransactionData(int page,int limit){
        HashMap hashMap = transactionDataService.selectTransactionData(page, limit);
        int count = (int) hashMap.get("p_count");
        List<TransactionData> transactionDataList = (List<TransactionData>) hashMap.get("p_cursor");
        System.out.println("总条数："+count);
        System.out.println("page="+page+",limit="+limit);
        HashMap tranMap = new HashMap();
        tranMap.put("count",count);
        tranMap.put("code",0);
        tranMap.put("msg","");
        tranMap.put("data",transactionDataList);
        System.out.println("基金大小"+transactionDataList.size());
        return tranMap;
    }
    @RequestMapping("/insertTransactionData")
    public int insertTransactionData(TransactionData transactionData){
        String s = dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD);
        transactionData.setTransactionDataId(s);

        System.out.println(transactionData);
       return transactionDataService.insertTransactionData(transactionData);
    }

    @RequestMapping("/deleteTransactionData")
    public int deleteTransactionData(int transactionDataId){
        return transactionDataService.deleteTransactionData(transactionDataId);
    }

    @RequestMapping("/updateTransactionData")
    public int updateTransactionData(TransactionData transactionData){
        return transactionDataService.updateTransactionData(transactionData);
    }
}
