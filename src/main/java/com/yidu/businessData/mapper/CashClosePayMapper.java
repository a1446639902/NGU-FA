package com.yidu.businessData.mapper;

import com.yidu.businessData.pojo.CashClosePayPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosePayMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:13 2020/9/1
 * @Version 1.0
 **/
@Mapper
public interface CashClosePayMapper {

    int insertCash(CashClosePayPojo cashClosePay);
    int deleteCash(int cashClosedPayId);
    int updateCash(CashClosePayPojo cashClosePay);
    void selectCash(HashMap userMap);
}
