package com.yidu.dayDispose.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface RevenueProvisionMapper {
    public void selectRevenueProvision(HashMap hashMap);

}
