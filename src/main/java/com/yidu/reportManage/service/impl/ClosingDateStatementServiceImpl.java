package com.yidu.reportManage.service.impl;


import com.yidu.reportManage.mapper.ClosingDateStatementMapper;
import com.yidu.reportManage.service.ClosingDateStatementService;
import com.yidu.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 成交结算日报表
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层实现类
 * @time 2020/9/16
 **/
@Service
public class ClosingDateStatementServiceImpl implements ClosingDateStatementService {
    @Resource
    ClosingDateStatementMapper closingDateStatementMapper;

    @Override
    public HashMap selectClosingDateStatement(int page, int limit, String dateTime) {
        if (dateTime==null){
             dateTime = DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        }
        String  sqlWhere=" AND dateTime='"+dateTime+"'";
        HashMap tranMap = new HashMap();
        String transactionData=" (select * from transactionData tr left join securities se on tr.securitiesId=se.securitiesId left join account ac on tr.accountId=ac.accountId left join seate se on tr.seateId=se.seateId left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
        tranMap.put("p_tableName", transactionData);
        tranMap.put("p_condition",sqlWhere);
        tranMap.put("p_pageSize",limit);
        tranMap.put("p_page",page);
        tranMap.put("p_count",0);
        tranMap.put("p_cursor",null);
        closingDateStatementMapper.selectClosingDateStatement(tranMap);
        //添加流出合计，流入合计，清算合计
        /*double outMoney*/
        return tranMap;
    }
}
