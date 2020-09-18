package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName SettlementNettingMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 15:23 2020/9/18
 * @Version 1.0
 **/
@Mapper
public interface SettlementNettingMapper {
    @Select("select (case when EXCHANGE=1 then '上海' else '深圳' end)||(case when SECURITIESTYPE=1 then '债券' else '股票' end) " +
            "as name,sum(NETRECEIPTS*flag),sum(transfer),sum(brokerage),sum(stamp),sum(management),sum(TOTALSUM*flag) from (select * from TRANSACTIONDATA t" +
            "join (select * from SECURITIES) s on t.SECURITIESID=s.SECURITIESID) where SETTLEMENTDATE='{#SETTLEMENTDATE}' group by EXCHANGE,SECURITIESTYPE;")
    Map selectTable(Map map);
}
