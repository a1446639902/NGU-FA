package com.yidu.reportManage.service.impl;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
import com.yidu.reportManage.mapper.FundPortfolioStatementMapper;
import com.yidu.reportManage.service.FundPortfolioStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * xx类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Service
public class FundPortfolioStatementServiceImpl implements FundPortfolioStatementService {
    @Resource
    FundPortfolioStatementMapper fundPortfolioStatementMapper;

    @Override
    public List<NetValueOfStatisticalPojo> selectZhaiQuan(String time) {
        return fundPortfolioStatementMapper.selectZhaiQuan(time);
    }

    @Override
    public List<NetValueOfStatisticalPojo> selectGuPiao(String time) {
        return fundPortfolioStatementMapper.selectGuPiao(time);
    }

    @Override
    public List<NetValueOfStatisticalPojo> selectZiChanJingZhi(String time) {
        return fundPortfolioStatementMapper.selectZiChanJingZhi(time);
    }

    @Override
    public List<NetValueOfStatisticalPojo> selectFuZhai(String time) {
        return fundPortfolioStatementMapper.selectFuZhai(time);
    }
}
