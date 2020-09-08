package com.yidu.businessData.service;

import com.yidu.businessData.pojo.DepositPojo;

import java.util.HashMap;

/**
 * 存款业务表
 * @Type 服务层
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/7
 **/
public interface DepositService {
    public HashMap selectDeposit(int page,int limit,String businessType,String dateEnd);
    public int insertDeposit(DepositPojo depositPojo);
    public int updateDeposit(DepositPojo depositPojo);
    public int deleteDeposit(int depositId);
}
