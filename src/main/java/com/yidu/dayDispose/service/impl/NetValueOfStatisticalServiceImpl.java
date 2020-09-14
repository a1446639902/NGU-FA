package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.NetValueOfStatisticalMapper;
import com.yidu.dayDispose.pojo.*;
import com.yidu.dayDispose.service.NetValueOfStatisticalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 净值统计biz的实现类
 *
 * @author kangshao
 * @version 1.0
 **/
@Service
public class NetValueOfStatisticalServiceImpl implements NetValueOfStatisticalService {
    @Resource
    NetValueOfStatisticalMapper netValueOfStatisticalMapper;

    @Override
    public List<SelectAllMsgPojo> selectAllMsg(String time) {
        return netValueOfStatisticalMapper.selectAllMsg(time);
    }

    @Override
    public int insertTree(NetValueOfStatisticalPojo netValueOfStatisticalPojo) {
        return netValueOfStatisticalMapper.insertTree(netValueOfStatisticalPojo);
    }

    @Override
    public List<SelectAllMsgDemoOnePojo> selectAllMsgTwo() {
        return netValueOfStatisticalMapper.selectAllMsgTwo();
    }

    @Override
    public List<CashBlancePojo> selectCashBlance() {
        return netValueOfStatisticalMapper.selectCashBlance();
    }

    @Override
    public List<ServiceTypePojo> selectAmount(String amount) {
        return netValueOfStatisticalMapper.selectAmount(amount);
    }

    @Override
    public List<NetFinalPojo> selectNetBondInterest() {
        return netValueOfStatisticalMapper.selectNetBondInterest();
    }

    @Override
    public List<NetFinalPojo> selectTrusteeFee() {
        return netValueOfStatisticalMapper.selectTrusteeFee();
    }

    @Override
    public List<NetFinalPojo> selectAdministrativeFee() {
        return netValueOfStatisticalMapper.selectAdministrativeFee();
    }

    @Override
    public List<SecuritiesClearingAccountPojo> securitiesClearingAccount() {
        return netValueOfStatisticalMapper.securitiesClearingAccount();
    }

    @Override
    public Double selectTA(String time) {
        return netValueOfStatisticalMapper.selectTA(time);
    }


    @Override
    public int insertNetValueOfStatistical(NetValueOfStatisticalPojo netValueOfStatisticalPojo) {
        return netValueOfStatisticalMapper.insertNetValueOfStatistical(netValueOfStatisticalPojo);
    }

    @Override
    public List<NetValueOfStatisticalPojo> selectNetValueOfStatistical(String time) {
        return netValueOfStatisticalMapper.selectNetValueOfStatistical(time);
    }
}
