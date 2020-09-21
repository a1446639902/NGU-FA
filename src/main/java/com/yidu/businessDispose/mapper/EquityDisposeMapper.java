package com.yidu.businessDispose.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;
/**
 *@author wzh
 *date 2020-9-21
 * 权益处理设置Mapper接口
 */

@Mapper
public interface EquityDisposeMapper {
    /**
     * 权益处理查询方法
     * @param map
     */
    public void selectEquityDispose(Map map);

    /**
     * 权益处理修改方法
     * @param equityDataId
     * @param disposeStatus
     * @return
     */
    public int updateEquityDispose(String equityDataId, int disposeStatus);

    /**
     * 权益处理修改方法
     * @param equityDataId
     * @param disposeStatus
     * @return
     */
    public int updateEquityDisposeTwo(String equityDataId,int disposeStatus);
}
