package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**成交结算日报表
 * @author 黄志豪
 * @version 1.0
 * @Type dao层
 * @time 2020/9/16
 **/
@Mapper
public interface ClosingDateStatementMapper {
    public List selectClosingDateStatement(String  dateTime);
}
