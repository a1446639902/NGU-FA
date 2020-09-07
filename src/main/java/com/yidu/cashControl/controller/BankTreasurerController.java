package com.yidu.cashControl.controller;

import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.cashControl.service.BankTreasurerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 资金调拨表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/7
 **/
@RestController
@RequestMapping("/bankTreasurer")
public class BankTreasurerController {
    @Resource
    BankTreasurerService bankTreasurerService;
    @RequestMapping("/selectBankTreasurer")
    public HashMap selectBankTreasurer(int page,int limit,String dbTime,String allocatingType,String flag){
        System.out.println(page+limit);
        System.out.println(dbTime);
        System.out.println(allocatingType);
        System.out.println(flag);
        HashMap bankTreasurerMap = bankTreasurerService.selectBankTreasurer(page, limit,dbTime,allocatingType,flag);
        int count = (int) bankTreasurerMap.get("p_count");
        List<BankTreasurerPojo> bankTreasurerList= (List<BankTreasurerPojo>) bankTreasurerMap.get("p_cursor");
        HashMap hashMap = new HashMap();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",bankTreasurerList);
        hashMap.put("count",count);
        System.out.println(count);
        System.out.println(bankTreasurerList);
        return hashMap;
    }
    @RequestMapping("/insertBankTreasurer")
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo){
        System.out.println("新增");
        System.out.println(bankTreasurerPojo);
        return bankTreasurerService.insertBankTreasurer(bankTreasurerPojo);
    }
    @RequestMapping("/updateBankTreasurer")
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo){
        System.out.println("修改");
        System.out.println(bankTreasurerPojo);
        return bankTreasurerService.updateBankTreasurer(bankTreasurerPojo);
    }
    @RequestMapping("/deleteBankTreasurer")
    public int deleteBankTreasurer(String bankTreasurerIds){
        System.out.println("删除");
        System.out.println(bankTreasurerIds);
        return bankTreasurerService.deleteBankTreasurer(bankTreasurerIds);
    }
}
