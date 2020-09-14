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
    public HashMap selectAccount(int page,int limit,String accountName,String blankName,String fundId);
    public int insertAccount(AccountPojo accountPojo);
    public int deleteAccount(String accountId);
    public int updateAccount(AccountPojo accountPojo);
}

