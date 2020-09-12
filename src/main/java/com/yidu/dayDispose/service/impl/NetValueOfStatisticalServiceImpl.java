package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.NetValueOfStatisticalMapper;
import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
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
    public List<NetValueOfStatisticalPojo> selectNetValueOfStatistical() {
        return netValueOfStatisticalMapper.selectNetValueOfStatistical();
    }
}
