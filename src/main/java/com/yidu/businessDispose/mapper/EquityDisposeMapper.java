package com.yidu.businessDispose.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
@Mapper
public interface EquityDisposeMapper {
    public void selectEquityDispose(Map map);
}