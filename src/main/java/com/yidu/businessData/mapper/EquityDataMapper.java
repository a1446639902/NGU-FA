package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.EquityData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-21
 * 权益数据设置Mapper接口
 */

@Mapper
public interface EquityDataMapper {
    /**
     * 权益数据新增方法
     * @param equityData
     * @return
     */
    public int insertEquityData(EquityData equityData);

    /**
     * 权益数据删除方法
     * @param equityId
     * @return
     */
    public int  deleteEquityData(List equityId);

    /**
     * 权益数据修改方法
     * @param equityData
     * @return
     */
    public int updateEquityData(EquityData equityData);

    /**
     * 权益数据查询方法
     * @param map
     */
    public void selectEquityData(Map map);
}
