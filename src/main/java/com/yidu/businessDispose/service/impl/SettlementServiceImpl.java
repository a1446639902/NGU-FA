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
        //创建一个StringBuffer来进行节省空间 append进行追加
        StringBuffer sqlWhere = new StringBuffer();
        int Status;
        //需要转化为int类型int Status 条件查询的拼接条件 " AND status="+Status
        if (status!=null && !status.equals("")){
            Status=Integer.parseInt(status);
            sqlWhere.append(" AND status="+Status);
        }
        //条件查询的拼接条件 " AND dateTime LIKE  '%"+dateTime+"%'"
        if(dateTime!=null && !dateTime.equals("")){
            sqlWhere.append(" AND dateTime LIKE  '%"+dateTime+"%'" );
        }
        int ser;
        //需要转化为int类型int ser 条件查询的拼接条件 " AND transactionDataMode="+ser
        if (transactionDataMode!=null && !transactionDataMode.equals("")){
            ser=Integer.parseInt(transactionDataMode);
            sqlWhere.append(" AND transactionDataMode="+ser);
        }
        //多表查询
        String settlement=" (select * from transactionData tr left join securities se on tr.securitiesId=se.securitiesId left join account ac on tr.accountId=ac.accountId left join seate se on tr.seateId=se.seateId left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
        //创建一个HashMap
        HashMap settMap = new HashMap();
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
        //通过工具类JsonUtil.jsonToArrayList转换json数据为List集合
        List<Settlement> settlementList = JsonUtil.jsonToArrayList(settlement, Settlement.class);
        //遍历集合
        for (Settlement settlement1 : settlementList) {
            //创建资金调拨对象，进行赋值
            BankTreasurerPojo bankTreasurerPojo = new BankTreasurerPojo();
            bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
            bankTreasurerPojo.setFundId(settlement1.getFundId());
            int flag = settlement1.getFlag();
            bankTreasurerPojo.setTotalPrice(settlement1.getTotalSum()*flag);
            bankTreasurerPojo.setAccountId(settlement1.getAccountId());
            bankTreasurerPojo.setAccountName(settlement1.getAccountName());
            bankTreasurerPojo.setFlag(settlement1.getFlag());
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
        //前端发送的json的数据通过工具类JsonUtil.jsonToArrayList转换为List集合 遍历
        List<Settlement> settlementList = JsonUtil.jsonToArrayList(settlement, Settlement.class);
        for (Settlement settlement1 : settlementList) {
            int status = settlement1.getStatus();
            String transactionDataId = settlement1.getTransactionDataId();
            if (status==1){
                settlementMapper.updateSettlementTwo(0,transactionDataId);
                bankTreasurerMapper.deleteBankTreasurerByBusinessId(transactionDataId);
            }
        }
        return 1;
    }
}
