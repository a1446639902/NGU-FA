package com.yidu.taManage.controller;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.permission.aspect.NGULog;
import com.yidu.taManage.pojo.TaTransaction;
import com.yidu.taManage.service.TatransactionService;
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
 *  TA交易数据信息表数的控制器 处理器
 *  @author 唐赈环
 *  @date  2020/09/01 15点32分
 *  @version 版本1.0
 */
@RestController
public class TatransactionController {
    @Resource
    TatransactionService tatransactionService;
    @Resource
    DbUtil dbUtil;
    //登录验证
    @NGULog(message = "登录验证")
    @RequestMapping ("/insertTatTransaction")
    public int insertTatTransaction(TaTransaction taTransaction, HttpServletRequest request){
        taTransaction.setTaTransactionId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TT));
        //获取基金Id
        String fundId = GetFundIdUtil.getFundId(request);
        taTransaction.setFundId(fundId);
        System.out.println("taTransaction=" + taTransaction);
        int i= tatransactionService.insertTatransaction(taTransaction);
        return i;
    }
    @RequestMapping("/deleteTaTransaction")
    public void deleteTatransaction(String taTransactionId){
        System.out.println("进来了");
        tatransactionService.deleteTatransaction(taTransactionId);
    }
    @RequestMapping("/updateTaTransaction")
    public int updataTatransaction(TaTransaction taTransaction){
        System.out.println("进来了");
        System.out.println("修改时：" + taTransaction);
        int b = tatransactionService.updataTetransaction(taTransaction);

        return b;
    }
    @RequestMapping("/selectTaTransaction")
    public Map<String,Object> selectTatransaction(String page, String limit,String dateTime,String transactionStatus,String transactionType) {
        System.out.println("进来了");
        System.out.println(dateTime+","+","+transactionStatus+","+transactionType);
        Map<String,Object> map=tatransactionService.selectTatransaction(limit, page,dateTime,transactionStatus,transactionType);
        List<TaTransaction> tatransactionList= (List<TaTransaction>) map.get("taTransactionList");
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
    @RequestMapping("uploadTA")
    @ResponseBody
    public Map<String, Object> uploadTA(MultipartFile file) throws IOException {
        Map<String,Object> map = new HashMap<>();
        List<TaTransaction> list1 = marketDateUtil.getList(TaTransaction.class,file.getInputStream(),0);
        for (TaTransaction taTransaction : list1) {
            System.out.println(taTransaction);
            int i = tatransactionService.insertTatransaction(taTransaction);
            System.out.println(i);
        }
        return map;

    }
}
