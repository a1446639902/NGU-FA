package com.yidu.dayDispose.mapper;

import com.yidu.dayDispose.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 库存统计的mapper接口
 */
@Mapper
public interface InventoryMapper {

    /**
     * 证券库存的Mapper层  库存统计选择证券库存，点击统计后调用此方法
     * date:统计的日期
     * funId:基金表ID
     * @return
     */
    @Select("select\n" +
            "       NVL(jy.securitiesid,si.securitiesid) as securitiesid,\n" +
            "       sum(nvl(si.securitiesNum,0))-sum(nvl(jy.newNum,0)) as todayNum,\n" +
            "       sum(nvl(si.total,0))-sum(nvl(jy.newNetRectipts,0)) as todayTotal\n" +
            ",   (case when  ((sum(nvl(si.securitiesNum,0))-sum(nvl(jy.newNum,0)))=0) then 0\n" +
            "    else   (sum(nvl(si.total,0))-sum(nvl(jy.newNetRectipts,0)))/(sum(nvl(si.securitiesNum,0))-sum(nvl(jy.newNum,0))) end )\n" +
            "\n" +
            "\n" +
            "    as unitPrice\n" +
            "    from (select * from securitiesInventory where DATETIME=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd') and FUNDID=#{funId}) si\n" +
            "    full join(select sum(nvl(num,0)*flag) as newNum,sum(nvl(netReceipts,0)*flag) as newNetRectipts,securitiesId from transactionData where DATETIME=#{date} and FUNDID=#{funId} group by securitiesId)  jy\n" +
            "        on si.SECURITIESID=jy.SECURITIESID\n" +
            "        group by si.securitiesId,jy.securitiesId")
    public List<InventorySecurityEntity> selectInvventory(String date,String funId);

    /**
     * Mapper层  库存统计选择现金库存，点击统计后调用此方法
     * date:统计的日期
     * funId:基金表ID
     * @return
     */
    @Select("select (nvl(CASHBLANCE,0) + NVL(zj.totalNum,0)) as sumCa from\n" +
            "(select * from CASHINVENTORY where DATETIME=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd')) xj full join\n" +
            "\n" +
            "(select accountid,sum(totalprice+0) as totalNum from bankTreasurer where DBTIME=#{date}  group by accountid) zj\n" +
            " on xj.ACCOUNTID=zj.ACCOUNTID")
    public List<CaInventoryEntity> selectCaInventory(String date, String funId);

    /**
     * Mapper层  库存统计选择TA库存，点击统计后调用此方法
     * date:统计的日期
     * funId:基金表ID
     * @return
     */
    @Select("SELECT\n" +
            "         sum(tatotal) AS total,sum(tanum) AS num,fundId FROM\n" +
            "\n" +
            "\t(select tatotal,tanum,fundId from\n" +
            "    TAINVENTORY where fundId=#{funId} and\n" +
            "    datetime=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd')\n" +
            "    UNION\n" +
            "    select sum(totalMoney*(case transactionType when 3 then -1 else 1 end)) as totalMoney,\n" +
            "    sum(fundNum*(case transactionType when 3 then -1 else 1 end)) AS fundNum,fundId\n" +
            "    from\n" +
            "    TATransaction WHERE\n" +
            "    DATETIME=#{date} AND fundId=#{funId}  group by\n" +
            "    fundid) a\n" +
            "\tGROUP BY a.fundId")
    public List<TaInventoryEntityTwo> selectTaInventory(String date, String funId);


    /**
     * 现金应收应付的 库存统计
     * @param date
     * @param funId
     * @return
     */
    @Select("select nvl(tr.accountId,ca.accountId) as accountId,\n" +
            "    nvl(tr.serviceType,ca.businessType) as serv,\n" +
            "    nvl(ca.totalPrice,0)+nvl(tr.amount,0) as toca\n" +
            "    from\n" +
            "    (select sum(nvl(TOTALMONEY*BUSINESSSTATUS,0)) AS totalPrice,accountId,businesstype,BUSINESSSTATUS from CASHCLOSEDPAYINVENTORY\n" +
            "    where fundid=#{funId} and BUSINESSDATE=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd') and businessType in(1,2,3)\n" +
            "    GROUP BY accountId,businesstype,BUSINESSSTATUS) ca\n" +
            "    full join\n" +
            "        (select sum(nvl(amount*flag,0)) as amount,accountId,serviceType,flag\n" +
            "        from cashClosedPay where\n" +
            "    fundid=#{funId} and dateTime=#{date} and serviceType in(1,2,3)\n" +
            "    group by accountId,serviceType,flag) tr\n" +
            "    on ca.accountId=tr.accountId AND tr.serviceType=ca.businesstype AND ca.BUSINESSSTATUS=tr.flag\n")
    public List<CaYSYFInventoryEntity> selectCaYSYFInventory(String date, String funId);


    /**
     * 证券应收应付的库存统计
     * @param date
     * @param funId
     * @return
     */
    @Select("   select NVL(kc.flag,zj.FLAG) as flag,(NVL(totalPrice,0)+zj.tt) as tocal,NVL(kc.securityPeriodFlag,0) as securityPeriodFlag,NVL(kc.fundId,zj.FUNDID) as fundId,NVL(kc.securitiesId,zj.securitiesId) as securitiesId\n" +
            "    from\n" +
            "    (select * from securitiesClosedPayInventory where dateTime=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd')) kc\n" +
            "    full join\n" +
            "    (select sum(nvl(amount,0)*NVL(flag,0)) as tt,serviceType,FUNDID,securitiesId,FLAG from (select * from securitiesClosedPay where dateTime=#{date}) group by FLAG,accountId,serviceType,FUNDID,securitiesId) zj\n" +
            "    on kc.securitiesType=zj.serviceType and zj.FUNDID=kc.FUNDID")
    public List<SeYSYFInventoryEntity> selectSeYSYFInventory(String date, String funId);

}
