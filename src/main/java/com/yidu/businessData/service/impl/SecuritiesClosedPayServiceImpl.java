package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.SecuritiesClosedPayMapper;
import com.yidu.businessData.pojo.SecuritiesClosedPay;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.inventoryManage.mapper.SecuritiesInventoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
/*
 * wufeiyun暂时修改 证券应收应付
 * */
@Service
public class SecuritiesClosedPayServiceImpl implements SecuritiesClosedPayService {
    @Resource
    SecuritiesClosedPayMapper securitiesClosedPayMapper;

    @Override
    public int insertSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay) {
        return securitiesClosedPayMapper.insertSecuritiesClosedPay(securitiesClosedPay);
    }

    @Override
    public int deleteSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay) {
        return securitiesClosedPayMapper.deleteSecuritiesClosedPay(securitiesClosedPay);
    }
}
