package com.yidu.businessParameter.service.Impl;


import com.yidu.businessParameter.mapper.AccountMapper;
import com.yidu.businessParameter.pojo.AccountPojo;
import com.yidu.businessParameter.service.AccountService;

import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 现金账户表
 * @Type：服务层的实现类
 * @author 黄志豪
 * @version 1.3
 * @time 2020/9/4
 **/
@Transactional
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountMapper accountMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectAccount(int page,int limit,String accountName,String blankName,String fundId) {
        String sql="";
        if(accountName!=null && !accountName.equals("")){
            sql=sql+" and accountName like '%"+accountName+"%'";
        }
        if(blankName!=null && !blankName.equals("")){
            sql=sql+" and blankName='"+blankName+"'";
        }
        HashMap accountMap = new HashMap();
        //select * from account where fundId='"+289289289+"'"  根据基金Id查询现金账号
        accountMap.put("p_tableName","(select * from account where fundId='"+fundId+"')");
        accountMap.put("p_condition",sql);
        accountMap.put("p_pageSize",limit);
        accountMap.put("p_page",page);
        accountMap.put("p_count",0);
        accountMap.put("p_cursor",null);
        accountMapper.selectAccount(accountMap);
        return accountMap;
    }

    @Override
    public int insertAccount(AccountPojo accountPojo) {
        accountPojo.setAccountId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.A));
        return accountMapper.insertAccount(accountPojo);
    }

    @Override
    public int deleteAccount(String accountId) {
        //定义一个数组接收编号，切割字符串
        String[] split = accountId.split(",");
        //定义一个整型集合
        List<String> accountList = new ArrayList<String>();
        //循环数组
        for (String id : split) {
            //将数组循环的值添加到集合中，强转为整型
            accountList.add(id);
        }

        return accountMapper.deleteAccount(accountList);
    }

    @Override
    public int updateAccount(AccountPojo accountPojo) {
        return accountMapper.updateAccount(accountPojo);
    }
}
