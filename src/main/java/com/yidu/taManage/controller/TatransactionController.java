package com.yidu.taManage.controller;

import com.yidu.taManage.pojo.TaTransaction;
import com.yidu.taManage.service.TatransactionService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @RequestMapping ("/insertTatTransaction")
    public int insertTatTransaction(TaTransaction taTransaction){
        taTransaction.setTaTransactionId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TT));
        taTransaction.setFundId("60001");
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
    public Map<String,Object> selectTatransaction(String page, String limit) {
        System.out.println("进来了");
        Map<String,Object> map=tatransactionService.selectTatransaction(limit, page);
        List<TaTransaction> tatransactionList= (List<TaTransaction>) map.get("tatransactionList");
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
