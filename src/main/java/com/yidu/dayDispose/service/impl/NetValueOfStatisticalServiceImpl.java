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
    public List<SelectAllMsgDemoOnePojo> selectAllMsgTwo(String time) {
        return netValueOfStatisticalMapper.selectAllMsgTwo(time);
    }

    @Override
    public List<CashBlancePojo> selectCashBlance(String time) {
        return netValueOfStatisticalMapper.selectCashBlance(time);
    }

    @Override
    public List<ServiceTypePojo> selectAmount(String amount,String time) {
        return netValueOfStatisticalMapper.selectAmount(amount,time);
    }

    @Override
    public List<NetFinalPojo> selectNetBondInterest(String time) {
        return netValueOfStatisticalMapper.selectNetBondInterest(time);
    }

    @Override
    public List<NetFinalPojo> selectTrusteeFee(String time) {
        return netValueOfStatisticalMapper.selectTrusteeFee(time);
    }

    @Override
    public List<NetFinalPojo> selectAdministrativeFee(String time) {
        return netValueOfStatisticalMapper.selectAdministrativeFee(time);
    }

    @Override
    public List<SecuritiesClearingAccountPojo> securitiesClearingAccount(String time) {
        return netValueOfStatisticalMapper.securitiesClearingAccount(time);
    }

    @Override
    public Double selectTA(String time) {
        return netValueOfStatisticalMapper.selectTA(time);
    }

    @Override
    public int deleteNetValueOfStatistical(String time) {
        return netValueOfStatisticalMapper.deleteNetValueOfStatistical(time);
    }

    @Override
    public int deleteNetValueOfStatisticalToDay(String time) {
        return netValueOfStatisticalMapper.deleteNetValueOfStatisticalToDay(time);
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
