package com.yidu.dayDispose.mapper;

import com.yidu.dayDispose.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 净值统计dao层
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Mapper
public interface NetValueOfStatisticalMapper {
    //查询证券中股票的数据
    List<SelectAllMsgPojo> selectAllMsg(String time);

    //创建树形结构
    int insertTree(NetValueOfStatisticalPojo netValueOfStatisticalPojo);

    //查询证券中债券的数据
    List<SelectAllMsgDemoOnePojo> selectAllMsgTwo(String time);

    //查询现金表中的现金余额
    List<CashBlancePojo> selectCashBlance(String time);

    //查询利息，通过银行账户id查询
    List<ServiceTypePojo> selectAmount(String amount);

    //查询债券利息
    List<NetFinalPojo> selectNetBondInterest(String time);

    //查询托管费
    List<NetFinalPojo> selectTrusteeFee(String time);

    //查询管理费
    List<NetFinalPojo> selectAdministrativeFee(String time);

    //查询证券清算款
    List<SecuritiesClearingAccountPojo> securitiesClearingAccount(String time);

    //查询ta库存计算单位净值
    Double selectTA(String time);

    //删除净值统计表
    int deleteNetValueOfStatistical(String time);

    //拿到数据增加进净值统计表
    int insertNetValueOfStatistical(NetValueOfStatisticalPojo netValueOfStatisticalPojo);

    //查询净值统计表
    List<NetValueOfStatisticalPojo> selectNetValueOfStatistical(String time);

}
