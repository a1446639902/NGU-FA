package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.NetValueOfStatisticalMapper;
import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
import com.yidu.dayDispose.service.NetValueOfStatisticalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 净值统计biz的实现类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Service
public class NetValueOfStatisticalServiceImpl implements NetValueOfStatisticalService {
    @Resource
    NetValueOfStatisticalMapper netValueOfStatisticalMapper;

    @Override
    public HashMap selectNetValueOfStatistical() {
        HashMap hashMap = new HashMap();
        //查询的表名
        hashMap.put("p_tableName","valueStatistics");
        //查询的条件
        hashMap.put("p_condition","");
        //总条数
        hashMap.put("p_count",0);
        //游标标量
        hashMap.put("p_cursor",null);
        netValueOfStatisticalMapper.selectNetValueOfStatistical(hashMap);
        return hashMap;
    }
}
