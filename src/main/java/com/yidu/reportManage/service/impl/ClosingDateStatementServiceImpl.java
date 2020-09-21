package com.yidu.reportManage.service.impl;


import com.yidu.reportManage.mapper.ClosingDateStatementMapper;
import com.yidu.reportManage.pojo.ClosingDateStatementPojo;
import com.yidu.reportManage.service.ClosingDateStatementService;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 成交结算日报表
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层实现类
 * @time 2020/9/16
 **/
@Transactional
@Service
public class ClosingDateStatementServiceImpl implements ClosingDateStatementService {
    @Resource
    ClosingDateStatementMapper closingDateStatementMapper;

    @Override
    public HashMap selectClosingDateStatement(String dateTime) {
        if (dateTime==null){
             dateTime = DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        }

        ArrayList<ClosingDateStatementPojo> cdsList = (ArrayList<ClosingDateStatementPojo>) closingDateStatementMapper.selectClosingDateStatement(dateTime);
        int count = cdsList.size();
        //添加流出合计，流入合计，清算合计实体类
        double inTotalMoney=0;
        double outTotalMoney=0;
        for (ClosingDateStatementPojo closingDateStatementPojo : cdsList) {
            if (closingDateStatementPojo.getFlag()==1){
                inTotalMoney=inTotalMoney+closingDateStatementPojo.getTotalSum();
            }
            else {
                outTotalMoney=outTotalMoney+closingDateStatementPojo.getTotalSum();
            }
        }
        double finalToalMoney=inTotalMoney-outTotalMoney;    //大于0
        //double留2个小数点
        BigDecimal bg = new BigDecimal(inTotalMoney);
        inTotalMoney = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal bg1 = new BigDecimal(outTotalMoney);
        outTotalMoney = bg1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        BigDecimal bg2 = new BigDecimal(finalToalMoney);
        finalToalMoney = bg2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        ClosingDateStatementPojo pojo1 = new ClosingDateStatementPojo();
        pojo1.setSecuritiesId("流入合计");
        pojo1.setTotalSum(inTotalMoney);
        ClosingDateStatementPojo pojo2 = new ClosingDateStatementPojo();
        pojo2.setSecuritiesId("流出合计");
        pojo2.setTotalSum(outTotalMoney);
        ClosingDateStatementPojo pojo3 =new ClosingDateStatementPojo();
        pojo3.setSecuritiesId("清算合计");
        pojo3.setTotalSum(finalToalMoney);
        cdsList.add(pojo1);
        cdsList.add(pojo2);
        cdsList.add(pojo3);
        System.out.println(cdsList);
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("list",cdsList);
        hashMap.put("count",count);
        return hashMap;
    }
}
