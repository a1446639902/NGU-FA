package com.yidu.businessData.service;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;

import java.util.HashMap;
import java.util.List;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/12
 **/
public interface SecuritiesClosedPayService {
    public HashMap selectSecuritiesClosedPay(int page,int limit);
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo SecuritiesClosedPayPojo);
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo);
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds);
    public int deleteSecuritiesClosedPayByPojo(SecuritiesClosedPayPojo securitiesClosedPayPojo);
}