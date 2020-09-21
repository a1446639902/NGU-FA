package com.yidu.cashControl.controller;

import com.yidu.cashControl.pojo.TransferMoneyPojo;
import com.yidu.cashControl.service.TransferMoneyService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 划款指令表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/11
 **/
@RestController
@RequestMapping("/transferMoney")
public class TransferMoneyController {
    @Resource
    TransferMoneyService transferMoneyService;

    @NGULog(message="查询划款指令表")
    @RequestMapping("/selectTransferMoney")
    public HashMap selectTransferMoney(int page,int limit,String crossSectionDate){
        HashMap transferMoneyMap = transferMoneyService.selectTransferMoney(page, limit,crossSectionDate);
        int count = (int) transferMoneyMap.get("p_count");
        ArrayList<TransferMoneyPojo> transferMoneyList = (ArrayList<TransferMoneyPojo>) transferMoneyMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",transferMoneyList);
        return hashMap;
    }

    @NGULog(message="新增划款指令表")
    @RequestMapping("/insertTransferMoney")
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo,HttpServletRequest request){
        System.out.println("======================");
        System.out.println(transferMoneyPojo);
        String fundId = GetFundIdUtil.getFundId(request);
        System.out.println(fundId);
        transferMoneyPojo.setFoundId(fundId);
        return transferMoneyService.insertTransferMoney(transferMoneyPojo);
    }

    @NGULog(message="修改划款指令表")
    @RequestMapping("/updateTransferMoney")
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo){
        return transferMoneyService.updateTransferMoney(transferMoneyPojo);
    }

    @NGULog(message="删除划款指令表")
    @RequestMapping("/deleteTransferMoney")
    public int deleteTransferMoney(String transferMoneyIds){
        System.out.println("删除=====================");
        return transferMoneyService.deleteTransferMoney(transferMoneyIds);
    }



}
