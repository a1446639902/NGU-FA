package com.yidu.businessData.service;

import com.yidu.businessData.pojo.SecuritiesClosedPay;

import java.util.HashMap;
import java.util.Map;
/*
 * wufeiyun暂时修改 证券应收应付
 * */
public interface SecuritiesClosedPayService  {
    public int insertSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay);
    public int deleteSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay);
}
