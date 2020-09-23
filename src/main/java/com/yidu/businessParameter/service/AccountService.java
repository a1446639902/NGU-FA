package com.yidu.businessParameter.service;




import com.yidu.businessParameter.pojo.AccountPojo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 现金账号表
 * @Type:服务层
 * @author 黄志豪
 * @time    2020/9/4
 * @version  1.2
 **/
@Service
public interface AccountService {
    /**
     * 查询现金账号表的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param accountName 账号名称
     * @param blankName 银行名称
     * @param fundId 基金Id
     * @return 返回hashMap对象
     */
    public HashMap selectAccount(int page,int limit,String accountName,String blankName,String fundId);

    /**
     * 新增现金账号表的方法
     * @param accountPojo 现金账号表实体类
     * @return 返回1 新增成功 0 新增失败
     */
    public int insertAccount(AccountPojo accountPojo);

    /**
     * 删除现金账户表的方法
     * @param accountId 现金账户Id
     * @return 返回1 删除成功 0 删除失败
     */
    public int deleteAccount(String accountId);

    /**
     * 修改现金账户表的方法
     * @param accountPojo 现金账户的实体类
     * @return 返回1 修改成功 0 修改失败
     */
    public int updateAccount(AccountPojo accountPojo);
}

