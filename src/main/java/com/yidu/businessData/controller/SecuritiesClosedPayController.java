package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.SecuritiesClosedPay;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * wufeiyun暂时修改 证券应收应付
 * */
import javax.annotation.Resource;

@RestController
public class SecuritiesClosedPayController {
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;
    @RequestMapping("insertSecuritiesClosedPay")
    public int insertSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay){
        SecuritiesClosedPay securitiesClosedPay1 = new SecuritiesClosedPay();
//        securitiesClosedPay1.setSecuritiesClosedPayId("1221");
//        securitiesClosedPay1.setFundId("1231");
//        securitiesClosedPay1.setAccountId("121211");
//        securitiesClosedPay1.setServiceType(1);
//        securitiesClosedPay1.setAmount(121212);
//        securitiesClosedPay1.setDateTime("12121");
//        securitiesClosedPay1.setFlag(1);
//        securitiesClosedPay1.setSecuritiesId("10010120");
        int i = securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPay);
        return i;
    }
    @RequestMapping("deleteSecuritiesClosedPay")
    public int deleteSecuritiesClosedPay(SecuritiesClosedPay securitiesClosedPay){
//        SecuritiesClosedPay securitiesClosedPay1 = new SecuritiesClosedPay();
//        securitiesClosedPay1.setFundId("1231");
//        securitiesClosedPay1.setSecuritiesId("10010120");
//        securitiesClosedPay1.setDateTime("12121");
        int i = securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPay);
        return i;
    }
}
