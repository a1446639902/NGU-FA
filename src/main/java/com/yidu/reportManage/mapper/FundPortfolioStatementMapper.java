package com.yidu.reportManage.mapper;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * xx类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Mapper
public interface FundPortfolioStatementMapper {

    public List<NetValueOfStatisticalPojo> selectZhaiQuan(String time);

    public List<NetValueOfStatisticalPojo> selectGuPiao(String time);

    public List<NetValueOfStatisticalPojo> selectZiChanJingZhi(String time);

    public List<NetValueOfStatisticalPojo> selectFuZhai(String time);
}
