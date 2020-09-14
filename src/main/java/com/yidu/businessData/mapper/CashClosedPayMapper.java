package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.dayDispose.pojo.RevenueProvision;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
    int insertCashClosedPay(CashClosedPayPojo cashClosePay);
    int deleteCashClosedPay(String cashClosedPayId);
    int updateCashClosedPay(CashClosedPayPojo cashClosePay);
    void selectCashClosedPay(Map map);
    @Select("select cashClosedPayId from cashClosedPay where fundId=#{fundId} and serviceType=#{serviceType} and dateTime=#{dateTime} and flag=#{flag}")
    public String selectCashClosedPayId(Map map);
    //wufeiyun增加的删除接口
    int deleteNew(CashClosedPayPojo cashClosedPay);
}
