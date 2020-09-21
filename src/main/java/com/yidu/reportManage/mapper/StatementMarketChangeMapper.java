package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/20
 **/
@Mapper
public interface StatementMarketChangeMapper {
    public List selectStatementMarketChange (String dateTime);

}
