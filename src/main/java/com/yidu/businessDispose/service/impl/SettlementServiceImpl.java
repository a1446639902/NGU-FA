package com.yidu.businessDispose.service.impl;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessDispose.mapper.SettlementMapper;
import com.yidu.businessDispose.pojo.Settlement;
import com.yidu.businessDispose.service.SettlementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Tmac
 * @version 1.0
 * @time 2020/9/8  11:36
 **/
@Service
public class SettlementServiceImpl implements SettlementService {
    @Resource
    SettlementMapper settlementMapper;

    @Override
    public HashMap selectSettlement(int page, int limit,String status,String dateTime,String transactionDataMode) {
        StringBuffer sqlWhere = new StringBuffer();
        HashMap settMap = new HashMap();
        int Status;
        if (status!=null && !status.equals("")){
            Status=Integer.parseInt(status);
            sqlWhere.append(" AND status="+Status);
        }

        if(dateTime!=null && !dateTime.equals("")){
            sqlWhere.append(" AND dateTime LIKE  '%"+dateTime+"%'" );
        }
        int ser;
        if (transactionDataMode!=null && !transactionDataMode.equals("")){
            ser=Integer.parseInt(transactionDataMode);
            sqlWhere.append(" AND transactionDataMode="+ser);
        }
        String settlement=" (select * from transactionData tr left join securities se on tr.securitiesId=se.securitiesId left join account ac on tr.accountId=ac.accountId left join seate se on tr.seateId=se.seateId left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
        settMap.put("p_tableName", settlement);
        settMap.put("p_condition",sqlWhere.toString());
        settMap.put("p_pageSize",limit);
        settMap.put("p_page",page);
        settMap.put("p_count",0);
        settMap.put("p_cursor",null);
        settlementMapper.selectSettlement(settMap);
        return settMap;
    }

    @Override
    public int insertSettlement(Settlement settlement) {
        System.out.println(settlement);
        return settlementMapper.insertSettlement(settlement);
    }

    @Override
    public int deleteSettlement(String transactionDataId) {
        return settlementMapper.deleteSettlement(transactionDataId);
    }

    @Override
    public int updateSettlement(Settlement settlement) {
        return settlementMapper.updateSettlement(settlement);
    }
}
