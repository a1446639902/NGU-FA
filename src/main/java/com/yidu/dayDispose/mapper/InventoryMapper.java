package com.yidu.dayDispose.mapper;

import com.yidu.dayDispose.pojo.InventorySecurityEntity;
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



}
