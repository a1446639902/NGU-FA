package com.yidu.reportManage.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 *  席位成交明细表service层
 *  戴言露
 *  2020-9-17
 */
public interface SeateScheduleOfService {
    public HashMap selectSeateScheduleOf(int page,int limit,String fundName);
}
