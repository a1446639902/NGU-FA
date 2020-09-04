package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.EquityData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置Mapper接口
 */

@Mapper
public interface EquityDataMapper {
    public int insertEquityData(EquityData equityData);
    public int  deleteEquityData(List equityId);
    public int updateEquityData(EquityData equityData);
    public void selectEquityData(Map map);
}
