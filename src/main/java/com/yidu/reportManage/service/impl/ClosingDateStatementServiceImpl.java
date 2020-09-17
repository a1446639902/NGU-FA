package com.yidu.reportManage.service.impl;


import com.yidu.reportManage.mapper.ClosingDateStatementMapper;
import com.yidu.reportManage.pojo.ClosingDateStatementPojo;
import com.yidu.reportManage.service.ClosingDateStatementService;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.SysTableNameListUtil;
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
        HashMap cdsMap = new HashMap();
        String transactionData=" (select * from transactionData tr  join securities se on tr.securitiesId=se.securitiesId) ";
        cdsMap.put("p_tableName", transactionData);
        cdsMap.put("p_condition",sqlWhere);
        cdsMap.put("p_pageSize",limit);
        cdsMap.put("p_page",page);
        cdsMap.put("p_count",0);
        cdsMap.put("p_cursor",null);
        closingDateStatementMapper.selectClosingDateStatement(cdsMap);
        //添加流出合计，流入合计，清算合计实体类
        double inTotalMoney=0;
        double outTotalMoney=0;
        ArrayList<ClosingDateStatementPojo> cdsList = (ArrayList<ClosingDateStatementPojo>) cdsMap.get("p_cursor");
        for (ClosingDateStatementPojo closingDateStatementPojo : cdsList) {
            if (closingDateStatementPojo.getFlag()==1){
                inTotalMoney=inTotalMoney+closingDateStatementPojo.getTotalSum();
            }
            else {
                outTotalMoney=outTotalMoney+closingDateStatementPojo.getTotalSum();
            }
        }
        double finalToalMoney=inTotalMoney-outTotalMoney;    //大于0
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
        cdsMap.put("list",cdsList);
        return cdsMap;
    }
}
