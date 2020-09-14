package com.yidu.dayDispose.mapper;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 收益支付dao层
 * @ClassName IncomePaymentMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 8:53 2020/9/9
 * @Version 1.0
 **/
@Mapper
public interface IncomePaymentMapper {
    void selectCashClosedPays(Map map);
    void selectSecuritiesClosedPay(Map map);
    void selectTwoCost(Map map);
}
