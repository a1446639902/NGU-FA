package com.yidu.cashControl.service;

import com.yidu.cashControl.pojo.BankTreasurerPojo;

import java.util.HashMap;

/**
 * 资金调拨表
 * @Type 服务层
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/4
 **/
public interface BankTreasurerService {
    public HashMap selectBankTreasurer(int page,int limit,String dbTime,String allocatingType,String flag);
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo);
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo);
    public int deleteBankTreasurer(String bankTreasurerIds);
}
