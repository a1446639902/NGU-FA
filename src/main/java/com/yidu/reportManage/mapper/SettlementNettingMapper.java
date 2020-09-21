package com.yidu.reportManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName SettlementNettingMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 15:23 2020/9/18
 * @Version 1.0
 **/
@Mapper
public interface SettlementNettingMapper {
    Map selectTable(Map map);
}
