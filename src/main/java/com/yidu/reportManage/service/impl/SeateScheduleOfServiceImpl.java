package com.yidu.reportManage.service.impl;

import com.yidu.reportManage.mapper.SeateScheduleOfMapper;
import com.yidu.reportManage.service.SeateScheduleOfService;
import com.yidu.util.DateTimeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 席位成交明细表服务实现类
 * 戴言露
 * 2020-9-17
 */
@Service
public class SeateScheduleOfServiceImpl implements SeateScheduleOfService {
    @Resource
    SeateScheduleOfMapper seateScheduleOfMapper;

    @Override
    public HashMap selectSeateScheduleOf(int page, int limit, String fundName) {
//        if(dateTime==null){
//            dateTime = DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
//        }
//        String sqlWhere="AND dateTime='"+dateTime+"'";
//          HashMap tranMap = new HashMap();
//        String transactionData=" (select * from VarietiesRatePojo vrp left join securities se on tr.securitiesId=se.securitiesId left join fund fu on tr.fundName=fu.fundName left join TransactionData td on tr.num=td.num left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
           String sql="";
           if(fundName!=null&&!fundName.equals("")){
               sql = sql+"and fundName like '%"+ fundName + "%'";
           }
        System.out.println(sql);
           HashMap seateScheduleOfMap = new HashMap();
        seateScheduleOfMap.put("p_tableName","seateScheduleOf");
        seateScheduleOfMap.put("p_condition", sql);
        seateScheduleOfMap.put("p_pageSize", limit);
        seateScheduleOfMap.put("p_page", page);
        seateScheduleOfMap.put("p_count", 0);
        seateScheduleOfMap.put("p_cursor", null);
        seateScheduleOfMapper.selectSeateScheduleOf(seateScheduleOfMap);
        return seateScheduleOfMap;
    }
}
