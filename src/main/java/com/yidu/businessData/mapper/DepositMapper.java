package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.DepositPojo;

import java.util.HashMap;

/**
 * 存款业务表
 * @Type dao层
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/7
 **/

public interface DepositMapper {
    public void  selectDeposit(HashMap hashMap);
    public int insertDeposit(DepositPojo depositPojo);
    public int updateDeposit(DepositPojo depositPojo);
    public int deleteDeposit(int depositId);
}
