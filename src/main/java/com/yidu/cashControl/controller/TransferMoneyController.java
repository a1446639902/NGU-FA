package com.yidu.cashControl.controller;

import com.yidu.cashControl.pojo.TransferMoneyPojo;
import com.yidu.cashControl.service.TransferMoneyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/10
 **/
@RestController
@RequestMapping("/transferMoney")
public class TransferMoneyController {
    @Resource
    TransferMoneyService transferMoneyService;
    @RequestMapping("/selectTransferMoney")
    public HashMap selectTransferMoney(int page,int limit){
        HashMap transferMoneyMap = transferMoneyService.selectTransferMoney(page, limit);
        int count = (int) transferMoneyMap.get("p_count");
        ArrayList<TransferMoneyPojo> transferMoneyList = (ArrayList<TransferMoneyPojo>) transferMoneyMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",transferMoneyList);
        return hashMap;
    }
    @RequestMapping("/insertTransferMoney")
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo){
        System.out.println("======================");
        System.out.println(transferMoneyPojo);
        return transferMoneyService.insertTransferMoney(transferMoneyPojo);
    }
    @RequestMapping("/updateTransferMoney")
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo){
        return transferMoneyService.updateTransferMoney(transferMoneyPojo);
    }
    @RequestMapping("/deleteTransferMoney")
    public int deleteTransferMoney(String transferMoneyId){
        return transferMoneyService.deleteTransferMoney(transferMoneyId);
    }



}
