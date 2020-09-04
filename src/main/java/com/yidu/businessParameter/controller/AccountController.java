package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.AccountPojo;
import com.yidu.businessParameter.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 现金账户表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/3
 **/
@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping("/selectAccount")
    public HashMap selectAccount(int page,int limit,String selectAccountName,String selectBankName) {
        System.out.println("jintlia");
        System.out.println(page+","+limit+","+selectAccountName+","+selectBankName);
        HashMap hashMap = accountService.selectAccount(page,limit,selectAccountName,selectBankName);
        int count = (int) hashMap.get("p_count");
        List<AccountPojo> accountList = (List<AccountPojo>) hashMap.get("p_cursor");
        HashMap accountMap = new HashMap();
        accountMap.put("count",count);
        accountMap.put("code", 0);
        accountMap.put("msg", "");
        accountMap.put("data", accountList);
        return accountMap;
    }

    @RequestMapping("/deleteAccount")
    public int deleteAccount(String accountId) {
        System.out.println(accountId);
        return accountService.deleteAccount(accountId);
    }

    @RequestMapping("/insertAccount")
    public int insertAccount(AccountPojo accountPojo) {
        accountPojo.setAccountId("28");
        accountPojo.setFundId("5");
        System.out.println(accountPojo);
        return accountService.insertAccount(accountPojo);
    }

    @RequestMapping("/updateAccount")
    public int updateAccount(AccountPojo accountPojo) {
        System.out.println(accountPojo);
        System.out.println("修改的控制层");

        return accountService.updateAccount(accountPojo);
    }
}
