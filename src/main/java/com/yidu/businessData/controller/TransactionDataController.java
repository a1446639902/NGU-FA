package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.DbUtil;
import com.yidu.util.GetFundIdUtil;
import com.yidu.util.SysTableNameListUtil;
import com.yidu.util.marketDateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @NGULog(message = "查询交易数据表")
    @RequestMapping("/selectTransactionData")
    public HashMap selectTransactionData(int page,int limit,String dateTime,String securitiesName){
        HashMap hashMap = transactionDataService.selectTransactionData(page,limit,dateTime,securitiesName);
        int count = (int) hashMap.get("p_count");
        List<TransactionData> transactionDataList = (List<TransactionData>) hashMap.get("p_cursor");
        System.out.println("总条数："+count);
        System.out.println("page="+page+",limit="+limit+",dateTime="+dateTime+",securitiesName="+securitiesName);
        HashMap tranMap = new HashMap();
        tranMap.put("count",count);
        tranMap.put("code",0);
        tranMap.put("msg","");
        tranMap.put("data",transactionDataList);
        System.out.println("数据:"+transactionDataList);
        return tranMap;
    }
    @NGULog(message = "添加交易数据表")
    @RequestMapping("/insertTransactionData")
    public int insertTransactionData(TransactionData transactionData, HttpServletRequest request){
        transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
        transactionData.setFundId(GetFundIdUtil.getFundId(request));
        System.out.println(transactionData);
        if (transactionData.getTransactionDataMode()==1){
            transactionData.setFlag(-1);
        }else if (transactionData.getTransactionDataMode()==2 || transactionData.getTransactionDataMode()==3 || transactionData.getTransactionDataMode()==4){
            transactionData.setFlag(1);
        }
        return transactionDataService.insertTransactionData(transactionData);
    }
    @NGULog(message = "删除交易数据表")
    @RequestMapping("/deleteTransactionData")
    public int deleteTransactionData(String transactionDataId){
        return transactionDataService.deleteTransactionData(transactionDataId);
    }
    @NGULog(message = "批量删除交易数据表")
    @RequestMapping("/deleteTransactionDataTwo")
    public int deleteTransactionDataTwo(String transactionDataId) {
        return transactionDataService.deleteTransactionDataTwo(transactionDataId);
    }
    @NGULog(message = "修改交易数据表")
    @RequestMapping("/updateTransactionData")
    public int updateTransactionData(TransactionData transactionData){
        return transactionDataService.updateTransactionData(transactionData);
    }
    @NGULog(message = "交易数据导入")
    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> uploadMarket(MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        List<TransactionData> list = marketDateUtil.getList(TransactionData.class, file.getInputStream(), 0);
        for (TransactionData transactionData : list) {
            if(transactionData.getSecuritiesId()!=null) {
                transactionData.setTransactionDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TD));
                transactionData.setDateTime("2020-09-26");
                transactionData.setTransfer(0.2);
                transactionData.setTransactionDataMode(1);
                transactionDataService.insertTransactionData(transactionData);
            }
        }
        return map;

    }
}
