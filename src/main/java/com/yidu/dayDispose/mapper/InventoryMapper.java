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
            "    from (select * from securitiesInventory where DATETIME=#{date} and FUNDID=#{funId}) si\n" +
            "    full join(select sum(nvl(num,0)*flag) as newNum,sum(nvl(netReceipts,0)*flag) as newNetRectipts,securitiesId from transactionData where DATETIME=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd') and FUNDID=#{funId} group by securitiesId)  jy\n" +
            "        on si.SECURITIESID=jy.SECURITIESID\n" +
            "        group by si.securitiesId,jy.securitiesId")
    public List<InventorySecurityEntity> selectInvventory(String date,String funId);

    /**
     * 证券库存的Mapper层  库存统计选择现金库存，点击统计后调用此方法
     * date:统计的日期
     * funId:基金表ID
     * @return
     */
    @Select("select (nvl(SECURITIESNUM,0) + zj.totalNum) as sumCa from\n" +
            "(select * from CASHINVENTORY where DATETIME=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd')) xj full join\n" +
            "\n" +
            "(select accountid,sum(totalprice*flag) as totalNum from bankTreasurer where DBTIME=#{date}  group by accountid) zj\n" +
            " on xj.ACCOUNTID=zj.ACCOUNTID")
    public List<CaInventoryEntity> selectCaInventory(String date, String funId);

    /**
     * 证券库存的Mapper层  库存统计选择TA库存，点击统计后调用此方法
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
    @Select("    select nvl(xj.serviceType,kc.businessType) as serv,(NVL(totalMoney,0)+xj.tocal) as toca,xj.accountId\n" +
            "    from\n" +
            "    (select * from cashClosedPayInventory where businessDate=to_char(to_date(#{date},'yyyy-MM-dd')-1,'yyyy-MM-dd')) kc\n" +
            "    full join\n" +
            "    (select serviceType,dateTime,ACCOUNTID,sum(nvl(amount,0)*nvl(FLAG,0)) as tocal\n" +
            "    from (select * from cashClosedPay where DATETIME=#{date}) group by serviceType,DATETIME,ACCOUNTID) xj on xj.ACCOUNTID=kc.ACCOUNTID")
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
