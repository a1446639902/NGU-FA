package com.yidu.businessDispose.mapper;

import com.yidu.businessDispose.pojo.TaSettlement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * TA结算数据库访问接口
 * @author  唐赈环
 * @date  2020/09/09
 * @version 版本1.0
 */
@Mapper
public interface TaSettlementMapper {
    /**
     * 查询
     */
    void selectTaSettlement(Map map);
    /*
    修改
     */
    public int updateTaSettlement(int Status,String taTransactionId);
    public int updateTaSettlementTwo(int Status,String taTransactionId);
}
