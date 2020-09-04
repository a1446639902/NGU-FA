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
 * @version 1.2
 * @time 2020/9/4
 **/
@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    AccountService accountService;

    @RequestMapping("/selectAccount")
    public HashMap selectAccount(int page,int limit,String accountName,String blankName) {
        HashMap hashMap = accountService.selectAccount(page,limit,accountName,blankName);
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
        return accountService.deleteAccount(accountId);
    }

    @RequestMapping("/insertAccount")
    public int insertAccount(AccountPojo accountPojo) {
        return accountService.insertAccount(accountPojo);
    }

    @RequestMapping("/updateAccount")
    public int updateAccount(AccountPojo accountPojo) {
        return accountService.updateAccount(accountPojo);
    }
}
