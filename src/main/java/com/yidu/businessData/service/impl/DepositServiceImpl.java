package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.DepositMapper;
import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.businessData.service.DepositService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 存款业务表
 * @Type 服务层的实现类
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/8
 **/
@Transactional
@Service
public class DepositServiceImpl implements DepositService {
    @Resource
    DepositMapper depositMapper;
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
        depositPojo.setDepositId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.DE));
        depositPojo.setFundId("289289289");
        depositPojo.setDirectionOfMoney(-1);
        return depositMapper.insertDeposit(depositPojo);
    }

    @Override
    public int updateDeposit(DepositPojo depositPojo) {
        return depositMapper.updateDeposit(depositPojo);
    }

    @Override
    public int deleteDeposit(int depositId) {
        return depositMapper.deleteDeposit(depositId);
    }
}
