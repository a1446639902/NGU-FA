package com.yidu.dayDispose.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 收益支付服务类
 * @ClassName IncomePaymentService
 * @Description: TODO
 * @Author 硠君
 * @Date create in 8:54 2020/9/9
 * @Version 1.0
 **/
@Service
public interface IncomePaymentService {
    Map<String,Object> selectCashClosedPays(String pageSize, String page, String businessDate, HttpServletRequest request);
    Map<String,Object> selectSecuritiesClosedPay(String pageSize, String page,String businessDate,HttpServletRequest request);
    Map<String,Object> selectTwoCost(String pageSize, String page,String businessDate,HttpServletRequest request);
}
