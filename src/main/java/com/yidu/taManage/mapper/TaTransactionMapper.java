package com.yidu.taManage.mapper;

import com.yidu.taManage.pojo.TaTransaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * TA交易数据信息表数据库访问接口
 * @author  唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */

@Mapper
public interface TaTransactionMapper {
    /**
     * 查询基金信息
     * @param
     * @return List<Fund>
     */
    void selectTaTransaction(Map map);
    /**
     * 增加基金信息
     * @param tatransaction
     * @return int
     */
    int insertTaTransaction(TaTransaction tatransaction);
    /**
     * 删除基金信息
     * @param taTransactionId
     * @return
     */
    int deleteTaTransaction(List taTransactionId);
    /**
     * 修改基金信息
     * @param tatransaction
     * @return
     */
    int updateTaTransaction(TaTransaction tatransaction);
}
