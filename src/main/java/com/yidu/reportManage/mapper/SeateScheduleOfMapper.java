package com.yidu.reportManage.mapper;


import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;


/**
 * 席位成交明细表访问接口层
 * 戴言露
 * 2020-9-17
 */
@Mapper
public interface SeateScheduleOfMapper {
    public void selectSeateScheduleOf(HashMap hashMap);
}
