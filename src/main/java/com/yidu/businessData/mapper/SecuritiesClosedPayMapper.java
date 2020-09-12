package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.SecuritiesClosedPay;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.Map;
/*
* wufeiyun暂时修改 证券应收应付
* */
@Mapper
public interface SecuritiesClosedPayMapper {
    public int insertSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay);
    public int deleteSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay);
}
