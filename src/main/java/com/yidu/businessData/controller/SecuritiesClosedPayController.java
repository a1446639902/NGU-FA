package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/12
 **/
@RestController
@RequestMapping("/securitiesClosedPay")
public class SecuritiesClosedPayController {
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;
    @RequestMapping("/selectSecuritiesClosedPay")
    public HashMap selectSecuritiesClosedPay(int page,int limit){
        System.out.println("xinzeng========================");
        HashMap securitiesClosedPayMap = securitiesClosedPayService.selectSecuritiesClosedPay(page, limit);
        int count = (int) securitiesClosedPayMap.get("p_count");
        ArrayList<SecuritiesClosedPayPojo> securitiesClosedPayList = (ArrayList<SecuritiesClosedPayPojo>) securitiesClosedPayMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesClosedPayList);
        return hashMap;
    }
    @RequestMapping("/insertSecuritiesClosedPay")
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo, HttpServletRequest request){
        String fundId = GetFundIdUtil.getFundId(request);
        securitiesClosedPayPojo.setFundId(fundId);
        return securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPayPojo);

    }
    @RequestMapping("/updateSecuritiesClosedPay")
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo){
        return securitiesClosedPayService.updateSecuritiesClosedPay(securitiesClosedPayPojo);
    }
    @RequestMapping("/deleteSecuritiesClosedPay")
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds){
        return securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPayIds);
    }
}
