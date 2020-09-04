package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosedPayMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:13 2020/9/1
 * @Version 1.0
 **/
@Mapper
public interface CashClosedPayMapper {
    //select * from (select rownum as rn,d.* from(select * from p_tableName where 1=1 ) d where rownum<= p_page*p_pageSize) where rn>(p_page-1)*p_pageSize
                                                                //cashClosedPay
                                                                //join fund f on f.fundId=
                                                                //join securities s on s.securitiesId=
                                                                //join account a on a.accountId=
    int insertCashClosedPay(CashClosedPayPojo cashClosePay);
    int deleteCashClosedPay(String cashClosedPayId);
    int updateCashClosedPay(CashClosedPayPojo cashClosePay);
    void selectCashClosedPay(Map map);
}
