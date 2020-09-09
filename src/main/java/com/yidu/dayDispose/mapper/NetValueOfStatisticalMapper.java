package com.yidu.dayDispose.mapper;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 净值统计dao层
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Mapper
public interface NetValueOfStatisticalMapper {

    void selectNetValueOfStatistical(Map map);

}
