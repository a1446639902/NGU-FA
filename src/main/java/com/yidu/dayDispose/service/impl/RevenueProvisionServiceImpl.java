package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.RevenueProvisionMapper;
import com.yidu.dayDispose.service.RevenueProvisionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
@Service
public class RevenueProvisionServiceImpl implements RevenueProvisionService {
    @Resource
    RevenueProvisionMapper revenueProvisionMapper;
    @Override
    public HashMap selectRevenueProvision(int page, int limit) {
        HashMap revenueProvisionMap = new HashMap();
        revenueProvisionMap.put("p_tableName","(select round(ca.cashBlance* (a.cardRate/100/(case when a.procisionDays = 1 then 360\n" +
                "    when a.procisionDays=2 then 365 else 366 end )  ),2) as interest,a.cardRate,\n" +
                "    a.blankName,a.accountName,ca.cashBlance,a.deposit,(case when a.deposit = 1 then '活期'\n" +
                "     else  '定期' end) as depositName,ca.dateTime,(case when a.procisionDays = 1 then 360\n" +
                "    when a.procisionDays=2 then 365 else 366 end )as procisionDayName\n" +
                "from (select * from cashInventory where dateTime='2020-09-08')\n" +
                "    ca join account a on ca.accountId=a.accountId)");
        revenueProvisionMap.put("p_condition","");
        revenueProvisionMap.put("p_pageSize",limit);
        revenueProvisionMap.put("p_page",page);
        revenueProvisionMap.put("p_count",0);
        revenueProvisionMap.put("p_cursor",null);
        revenueProvisionMapper.selectRevenueProvision(revenueProvisionMap);
            return revenueProvisionMap;
        }

    @Override
    public HashMap selectBondInterest(int page, int limit ,String dateTime) {
        HashMap BondInterestMap = new HashMap();
        BondInterestMap.put("p_tableName","(select round(se.securitiesNum* (b.bondRate/365),2) as interest,\n" +
                "       b.securitiesId,se.dateTime,se.fundId,b.bondName,b.parRate,(case when b.payInterestNum=1 then '一年一次' when b.payInterestNum=2 then '一年两次' else '一年三次' end)as payInterest ,b.drawStartDate,b.payInterestNum,se.securitiesNum,b.bondRateAmount\n" +
                "from (select * from securitiesInventory where dateTime='2020-09-08')\n" +
                "    se join bond b on se.securitiesId = b.securitiesId)");
        BondInterestMap.put("p_condition","");
        BondInterestMap.put("p_pageSize",limit);
        BondInterestMap.put("p_page",page);
        BondInterestMap.put("p_count",0);
        BondInterestMap.put("p_cursor",null);
        revenueProvisionMapper.selectBondInterest(BondInterestMap);
        return BondInterestMap;
    }
}

