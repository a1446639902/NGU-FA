package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.AccountPojo;
import com.yidu.businessParameter.service.AccountService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    /**
     * 查询现金账号表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param accountName 账号名称
     * @param blankName 银行名称
     * @param request request请求对象
     * @return 返回hashMap对象
     */
    @NGULog(message="查询现金账户表")
    @RequestMapping("/selectAccount")
    public HashMap selectAccount(int page, int limit, String accountName, String blankName,HttpServletRequest request) {
        String fundId = GetFundIdUtil.getFundId(request);
        System.out.println(fundId);
        HashMap hashMap = accountService.selectAccount(page,limit,accountName,blankName,fundId);
        int count = (int) hashMap.get("p_count");
        List<AccountPojo> accountList = (List<AccountPojo>) hashMap.get("p_cursor");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap accountMap = new HashMap();
        accountMap.put("count",count);
        accountMap.put("code", 0);
        accountMap.put("msg", "");
        accountMap.put("data", accountList);
        return accountMap;
    }

    /**
     * 删除现金账号表的方法
     * @param accountId 现金账户Id
     * @return 返回1 删除成功 0 删除失败
     */
    @NGULog(message="删除现金账户表")
    @RequestMapping("/deleteAccount")
    public int deleteAccount(String accountId) {
        return accountService.deleteAccount(accountId);
    }

    /**
     * 新增现金账号表的方法
     * @param accountPojo 现金账号表实体类
     * @param request  request请求对象
     * @return 返回1 新增成功 0 新增失败
     */
    @NGULog(message="新增现金账户表")
    @RequestMapping("/insertAccount")
    public int insertAccount(AccountPojo accountPojo,HttpServletRequest request) {
        String fundId = GetFundIdUtil.getFundId(request);
        accountPojo.setFundId(fundId);
        return accountService.insertAccount(accountPojo);
    }

    /**
     * 修改现金账户表的方法
     * @param accountPojo 现金账户的实体类
     * @return 返回1 修改成功 0 修改失败
     */
    @NGULog(message="修改现金账户表")
    @RequestMapping("/updateAccount")
    public int updateAccount(AccountPojo accountPojo) {
        System.out.println("------------");
        System.out.println(accountPojo);
        return accountService.updateAccount(accountPojo);
    }
}
