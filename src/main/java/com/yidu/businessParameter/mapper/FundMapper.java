package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.Fund;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Type:dao层
 * @author Tmac
 * @time 2020/9/1  9:09
 * @version   1.0
 **/
@Mapper
public interface FundMapper {
    public void selectFund(HashMap fundMap);
    public int insertFund(Fund fund);
    public int deleteFund(List fundId);
    public int updateFund(Fund fund);
}
