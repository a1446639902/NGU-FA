package com.yidu.cashControl.service;

import com.yidu.cashControl.pojo.TransferMoneyPojo;

import java.util.HashMap;

/**
 * 划款指令表
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层接口
 * @time 2020/9/10
 **/
public interface TransferMoneyService {
    public HashMap selectTransferMoney(int page,int limit,String crossSectionDate);
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo);
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo);
    public int deleteTransferMoney(String transferMoneyIds);
}
