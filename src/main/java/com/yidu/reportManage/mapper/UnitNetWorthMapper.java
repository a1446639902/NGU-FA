package com.yidu.reportManage.mapper;

import com.yidu.businessParameter.pojo.Seate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName UnitNetWorthMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:23 2020/9/20
 * @Version 1.0
 **/
@Mapper
public interface UnitNetWorthMapper {
    @Select("select VALUESTATISTICSDATE,MARKETVALUE from VALUESTATISTICS where VALUESTATISTICSDATE like '#{dateTime}%' and PROJECTNAME='基金单位净值' order by VALUESTATISTICSDATE")
    List<Double> lineChart(String month);
}
