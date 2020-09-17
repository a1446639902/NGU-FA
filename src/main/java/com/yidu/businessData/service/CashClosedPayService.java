package com.yidu.businessData.service;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.dayDispose.pojo.RevenueProvision;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *现金应收应付服务类
 * @ClassName CashClosedPayService
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:51 2020/9/1
 * @Version 1.0
 **/
@Service
public interface CashClosedPayService {
    /**
     * @author 硠君
     * @Description
     * @Date 11:53 2020/9/15
     * @Parm [cashClosePay, request]
     * @return int
     **/
    int insertCashClosedPay(CashClosedPayPojo cashClosePay,HttpServletRequest request);
    /**
     * @author 硠君
     * @Description
     * @Date 11:53 2020/9/15
     * @Parm [cashClosedPayId]
     * @return int
     **/
    int deleteCashClosedPay(String cashClosedPayId);
    /**
     * @author 硠君
     * @Description
     * @Date 11:53 2020/9/15
     * @Parm [cashClosePay]
     * @return int
     **/
    int updateCashClosedPay(CashClosedPayPojo cashClosePay);
    /**
     * @author 硠君
     * @Description
     * @Date 11:53 2020/9/15
     * @Parm [pageSize, page, dateTime, serviceType]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> selectCashClosedPay(String pageSize, String page,String dateTime,String serviceType);
    /**
     * @author 硠君
     * @Description
     * @Date 11:54 2020/9/15
     * @Parm [map]
     * @return java.lang.String
     **/
    public String selectCashClosedPayId(Map map);
    //wufeiyun
    int deleteNew(CashClosedPayPojo cashClosedPay);
}
