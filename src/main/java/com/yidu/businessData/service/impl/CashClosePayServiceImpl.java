package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.CashClosePayMapper;
import com.yidu.businessData.pojo.CashClosePayPojo;
import com.yidu.businessData.service.CashClosePayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosePayServiceImpl
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:53 2020/9/1
 * @Version 1.0
 **/
@Service
public class CashClosePayServiceImpl implements CashClosePayService {
    @Resource
    CashClosePayMapper cashClosePayMapper;

    @Override
    public int insertCash(CashClosePayPojo cashClosePay) {
        return cashClosePayMapper.insertCash(cashClosePay);
    }

    @Override
    public int deleteCash(int cashClosedPayId) {
        return cashClosePayMapper.deleteCash(cashClosedPayId);
    }

    @Override
    public int updateCash(CashClosePayPojo cashClosePay) {
        return cashClosePayMapper.updateCash(cashClosePay);
    }

    @Override
    public List<CashClosePayPojo> selectCash() {
        HashMap hashMap = new HashMap();
        hashMap.put("p_tableName","cashClosePay");
        hashMap.put("p_condition","");
        hashMap.put("p_pageSize",4);
        hashMap.put("p_page",1);
        hashMap.put("p_count",0);
        hashMap.put("p_cursor",null);
        cashClosePayMapper.selectCash(hashMap);
        List<CashClosePayPojo> cashClosePayList = (List<CashClosePayPojo>) hashMap.get("p_cursor");
        return cashClosePayList;
    }
}
