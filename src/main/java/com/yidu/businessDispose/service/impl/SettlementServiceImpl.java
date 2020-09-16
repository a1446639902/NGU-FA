package com.yidu.businessDispose.service.impl;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessDispose.mapper.SettlementMapper;
import com.yidu.businessDispose.pojo.Settlement;
import com.yidu.businessDispose.service.SettlementService;
import com.yidu.cashControl.mapper.BankTreasurerMapper;
import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.util.DbUtil;
import com.yidu.util.JsonUtil;
import com.yidu.util.SysTableNameListUtil;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Tmac
 * @version 1.0
 * @time 2020/9/8  11:36
 **/
@Service
public class SettlementServiceImpl implements SettlementService {
    @Resource
    SettlementMapper settlementMapper;

    @Resource
    BankTreasurerMapper bankTreasurerMapper;
    @Resource
    DbUtil dbUtil;
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
    //结算修改状态添加资金调拨
    @Override
    public int updateSettlement(String settlement) {
        List<Settlement> settlementList = JsonUtil.jsonToArrayList(settlement, Settlement.class);
        for (Settlement settlement1 : settlementList) {
            BankTreasurerPojo bankTreasurerPojo = new BankTreasurerPojo();
            bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
            bankTreasurerPojo.setFundId(settlement1.getFundId());
            bankTreasurerPojo.setTotalPrice(settlement1.getTotalSum());
            bankTreasurerPojo.setAccountId(settlement1.getAccountId());
            bankTreasurerPojo.setAccountName(settlement1.getAccountName());
            int transactionDataMode = settlement1.getTransactionDataMode();

            System.out.println("--------------------------------"+transactionDataMode);
            if (transactionDataMode==1){
                bankTreasurerPojo.setFlag(-1);
            }else if (transactionDataMode==2){
                bankTreasurerPojo.setFlag(1);
            }
            bankTreasurerPojo.setDbTime(settlement1.getSettlementDate());
            bankTreasurerPojo.setDateTime(settlement1.getDateTime());
            bankTreasurerPojo.setBusinessId(settlement1.getTransactionDataId());
            bankTreasurerPojo.setAllocatingType(3);
            settlement1.setTransactionDataDesc("");
            bankTreasurerPojo.setBankTreasurerDesc(settlement1.getTransactionDataDesc());
            int status = settlement1.getStatus();
            String transactionDataId = settlement1.getTransactionDataId();
            if (status==0){
                settlementMapper.updateSettlement(1,transactionDataId);
                bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);
            }
            System.out.println(bankTreasurerPojo);
        }
        return 1;
    }
    //反结算修改状态删除资金调拨
    @Override
    public int updateSettlementTwo(String settlement) {
        List<Settlement> settlementList = JsonUtil.jsonToArrayList(settlement, Settlement.class);
        for (Settlement settlement1 : settlementList) {
            System.out.println(settlement1);
            int status = settlement1.getStatus();
            String transactionDataId = settlement1.getTransactionDataId();
            System.out.println(status);
            if (status==1){
                settlementMapper.updateSettlementTwo(0,transactionDataId);
                bankTreasurerMapper.deleteBankTreasurerByBusinessId(transactionDataId);
            }
        }
        return 1;
    }
}
