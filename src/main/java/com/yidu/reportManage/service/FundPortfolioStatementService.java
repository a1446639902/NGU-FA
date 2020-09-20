package com.yidu.reportManage.service;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;

import java.util.List;

/**
 * xx类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public interface FundPortfolioStatementService {

    public List<NetValueOfStatisticalPojo> selectZhaiQuan(String time);

    public List<NetValueOfStatisticalPojo> selectGuPiao(String time);

    public List<NetValueOfStatisticalPojo> selectZiChanJingZhi(String time);

    public List<NetValueOfStatisticalPojo> selectFuZhai(String time);
}
