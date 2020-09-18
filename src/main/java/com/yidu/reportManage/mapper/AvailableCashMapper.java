package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * 报表管理：现金头寸报表的Mapper层
 * date：2020/9/18
 * @Mr.Zou
 */
@Mapper
public interface AvailableCashMapper {

    void selectAvailable(Map map);

}
