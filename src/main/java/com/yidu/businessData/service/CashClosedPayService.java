package com.yidu.businessData.service;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.dayDispose.pojo.RevenueProvision;
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
    int insertCashClosedPay(CashClosedPayPojo cashClosePay);
    int deleteCashClosedPay(String cashClosedPayId);
    int updateCashClosedPay(CashClosedPayPojo cashClosePay);
    Map<String,Object> selectCashClosedPay(String pageSize, String page,String dateTime,String serviceType);

    //wufeiyun
    int deleteNew(CashClosedPayPojo cashClosedPay);
}
