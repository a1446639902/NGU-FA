package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.EquityData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置Mapper接口
 */

@Mapper
public interface EquityDataMapper {
    public List<EquityData> selectEquityDataMapper();
}
