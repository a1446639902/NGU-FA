package com.yidu.businessParameter.service;




import com.yidu.businessParameter.pojo.AccountPojo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * 现金账号表
 * @Type:服务层
 * @author 黄志豪
 * @time    2020/9/3
 * @version  1.1
 **/
@Service
public interface AccountService {
    public HashMap selectAccount(int page,int limit,String selectAccountName,String selectBankName);
    public int insertAccount(AccountPojo accountPojo);
    public int deleteAccount(String accountId);
    public int updateAccount(AccountPojo accountPojo);
}

