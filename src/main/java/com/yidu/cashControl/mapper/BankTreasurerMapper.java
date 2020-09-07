package com.yidu.cashControl.mapper;

import com.yidu.cashControl.pojo.BankTreasurerPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 资金调拨表
 * @Type dao层
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/4
 **/
@Mapper
public interface BankTreasurerMapper {
    public void selectBankTreasurer(HashMap hashMap);
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo);
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo);
    public int deleteBankTreasurer(List bankTreasurerIdList);
}
