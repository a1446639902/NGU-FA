package com.yidu.cashControl.service;

import com.yidu.cashControl.pojo.TransferMoneyPojo;

import java.util.HashMap;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/10
 **/
public interface TransferMoneyService {
    public HashMap selectTransferMoney(int page,int limit);
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo);
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo);
    public int deleteTransferMoney(String transferMoneyId);
}
