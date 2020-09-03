package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.Fund;

import java.util.HashMap;

/**
 * 基金参数
 * @Type:服务层
 * @author Tmac
 * @time 2020/9/1  9:11
 * @version   1.1
 **/

public interface FundService {
    public HashMap selectFund(int page,int limit);
    public int insertFund(Fund fund);
    public int deleteFund(String fundId);
    public int updateFund(Fund fund);
}
