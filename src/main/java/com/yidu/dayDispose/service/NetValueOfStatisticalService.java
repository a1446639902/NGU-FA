package com.yidu.dayDispose.service;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;

import java.util.List;

/**
 * 净值统计biz层
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public interface NetValueOfStatisticalService {

    List<NetValueOfStatisticalPojo> selectNetValueOfStatistical();
}
