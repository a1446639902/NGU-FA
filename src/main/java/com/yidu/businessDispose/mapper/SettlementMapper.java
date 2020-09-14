package com.yidu.businessDispose.mapper;

import com.yidu.businessDispose.pojo.Settlement;
import org.apache.ibatis.annotations.Mapper;


import java.util.HashMap;
import java.util.List;

/**
 * 交易结算
 * @author Tmac
 * @version 1.0
 * @time 2020/9/8  11:35
 **/
@Mapper
public interface SettlementMapper {
        public void selectSettlement(HashMap hashMap);
        public int insertSettlement(Settlement settlement);
        public int deleteSettlement(String transactionDataId);
        public int updateSettlement(int status,String transactionDataId);
        public int updateSettlementTwo(int status,String transactionDataId);
    }
