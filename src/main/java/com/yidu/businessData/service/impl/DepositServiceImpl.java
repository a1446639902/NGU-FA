package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.DepositMapper;
import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.businessData.service.DepositService;
import com.yidu.cashControl.mapper.BankTreasurerMapper;
import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 存款业务表
 * @Type 服务层的实现类
 * @author 黄志豪
 * @version 1.2
 * @time 2020/9/9
 **/
@Transactional
@Service
public class DepositServiceImpl implements DepositService {
    @Resource
    DepositMapper depositMapper;
    @Resource
    BankTreasurerMapper bankTreasurerMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectDeposit(int page,int limit,String businessType,String dateEnd) {
        HashMap depositMap = new HashMap<>();
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println(stringBuffer.toString());
        if(businessType!=null && !businessType.equals("")){
            stringBuffer.append(" and businessType="+businessType);
        }
        if(dateEnd!=null && !dateEnd.equals("")){
            stringBuffer.append(" and endDate='"+dateEnd+"'");
        }
        depositMap.put("p_tableName","(select deposit.*,account.accountName outAccountName, (select accountName from account where accountId=deposit.inAccountId) inAccountName from deposit join account on deposit.outAccountId = account.accountid)");
        depositMap.put("p_condition",stringBuffer.toString());
        depositMap.put("p_pageSize",limit);
        depositMap.put("p_page",page);
        depositMap.put("p_count",0);
        depositMap.put("p_cursor",null);
        depositMapper.selectDeposit(depositMap);
        System.out.println(depositMap.get("p_cursor"));
        return depositMap;
    }

    @Override
    public int insertDeposit(DepositPojo depositPojo) {
        System.out.println("====================================");
        depositPojo.setDepositId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.DE));
        System.out.println(depositPojo);


        BankTreasurerPojo bankTreasurerPojo = new BankTreasurerPojo();
        //主账号流出
        bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurerPojo.setFundId(depositPojo.getFundId());
        bankTreasurerPojo.setTotalPrice(depositPojo.getMoney());
        bankTreasurerPojo.setAccountId(depositPojo.getOutAccountId());
        bankTreasurerPojo.setAccountName(depositPojo.getOutAccountName());
        bankTreasurerPojo.setFlag(-1);
        //调拨日期为存款业务的业务日期
        bankTreasurerPojo.setDbTime(depositPojo.getBusinessDate());
        //业务日期为存款的当前日期
        String dateTime = DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        bankTreasurerPojo.setDateTime(dateTime);
        bankTreasurerPojo.setBusinessId(depositPojo.getDepositId());
        bankTreasurerPojo.setAllocatingType(5);
        bankTreasurerPojo.setBankTreasurerDesc(depositPojo.getDepositDesc());
        System.out.println(bankTreasurerPojo);
        //调用资金调拨表的新增方法
        bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);
        //副账户流入
        bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurerPojo.setAccountId(depositPojo.getInAccountId());
        bankTreasurerPojo.setAccountName(depositPojo.getInAccountName());
        bankTreasurerPojo.setFlag(1);
        //调用资金调拨表的新增方法
        bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);
        return depositMapper.insertDeposit(depositPojo);
    }

    @Override
    public int updateDeposit(DepositPojo depositPojo) {
        depositPojo.setFlag(1);
        BankTreasurerPojo bankTreasurerPojo = new BankTreasurerPojo();
        //主账号流入
        bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurerPojo.setFundId(depositPojo.getFundId());
        bankTreasurerPojo.setTotalPrice(depositPojo.getMoney());
        bankTreasurerPojo.setAccountId(depositPojo.getOutAccountId());
        bankTreasurerPojo.setAccountName(depositPojo.getOutAccountName());
        bankTreasurerPojo.setFlag(1);
        //获得点击到期处理业务的日期
        String dateTime = DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        //调拨日期
        bankTreasurerPojo.setDbTime(dateTime);
        //业务日期
        bankTreasurerPojo.setDateTime(dateTime);
        bankTreasurerPojo.setBusinessId(depositPojo.getDepositId());
        bankTreasurerPojo.setAllocatingType(5);
        bankTreasurerPojo.setBankTreasurerDesc(depositPojo.getDepositDesc());
        System.out.println(bankTreasurerPojo);
        //调用资金调拨表的新增方法
        bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);
        //副账户流出
        bankTreasurerPojo.setAccountId(depositPojo.getInAccountId());
        bankTreasurerPojo.setAccountName(depositPojo.getInAccountName());
        bankTreasurerPojo.setFlag(-1);
        //调用资金调拨表的新增方法
        bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);

        return depositMapper.updateDeposit(depositPojo);
    }

    @Override
    public int deleteDeposit(String depositId) {
        bankTreasurerMapper.deleteBankTreasurerByBusinessId(depositId);
        return depositMapper.deleteDeposit(depositId);
    }
}
