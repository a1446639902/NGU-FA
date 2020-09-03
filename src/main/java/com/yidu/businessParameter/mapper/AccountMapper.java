package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.AccountPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 现金账户表
 * @Type:dao层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/3
 **/
@Mapper
public interface AccountMapper {
    public void selectAccount(HashMap hashMap);
    public int insertAccount(AccountPojo accountPojo);
    public int deleteAccount(List accountIdList);
    public int updateAccount(AccountPojo accountPojo);
}
