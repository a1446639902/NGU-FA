package com.yidu.businessData.service;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/12
 **/
public interface SecuritiesClosedPayService {
    public HashMap selectSecuritiesClosedPay(int page,int limit,String dateTime);
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo SecuritiesClosedPayPojo);
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo);
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds);
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo);
    public String selectSecuritiesClosedPayId(Map map);
}