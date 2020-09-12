package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 证券应收应付
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/12
 **/
@Mapper
public interface SecuritiesClosedPayMapper {
    public void selectSecuritiesClosedPay(HashMap hashMap);
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo SecuritiesClosedPayPojo);
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo);
    public int deleteSecuritiesClosedPay(List securitiesClosedPayIdList);
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo);
}

