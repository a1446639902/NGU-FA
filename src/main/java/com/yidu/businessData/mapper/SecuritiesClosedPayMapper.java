package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 证券应收应付
 * @author 黄志豪
 * @version 1.0
 * @Type dao层
 * @time 2020/9/12
 **/
@Mapper
public interface SecuritiesClosedPayMapper {
    public void selectSecuritiesClosedPay(HashMap hashMap);
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo SecuritiesClosedPayPojo);
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo);
    public int deleteSecuritiesClosedPay(List securitiesClosedPayIdList);
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo);
    @Select("select securitiesClosedPayId from securitiesClosedPay where fundId=#{fundId} and serviceType=#{serviceType} and dateTime=#{dateTime} and flag=#{flag}")
    public String selectSecuritiesClosedPayId(Map map);
}

