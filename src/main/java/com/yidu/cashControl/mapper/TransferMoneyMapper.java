package com.yidu.cashControl.mapper;

import com.yidu.cashControl.pojo.TransferMoneyPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/10
 **/
@Mapper
public interface TransferMoneyMapper {
    public void selectTransferMoney(HashMap hashMap);
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo);
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo);
    public int deleteTransferMoney(List transferMoneyIdList);
    public TransferMoneyPojo selectTransferMoneyByTransferMoneyId(String transferMoneyId);
}
