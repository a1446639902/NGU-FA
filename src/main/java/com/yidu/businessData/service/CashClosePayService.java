package com.yidu.businessData.service;

import com.yidu.businessData.pojo.CashClosePayPojo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosePayService
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:51 2020/9/1
 * @Version 1.0
 **/
@Service
public interface CashClosePayService {
    int insertCash(CashClosePayPojo cashClosePay);
    int deleteCash(int cashClosedPayId);
    int updateCash(CashClosePayPojo cashClosePay);
    List<CashClosePayPojo> selectCash();
}
