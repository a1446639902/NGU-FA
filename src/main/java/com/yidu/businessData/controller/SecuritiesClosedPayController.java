package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.SecuritiesClosedPayPojo;
import com.yidu.businessData.service.SecuritiesClosedPayService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 证券应收应付表
 * @author 黄志豪
 * @version 1.0
 * @Type 控制层
 * @time 2020/9/12
 **/
@RestController
@RequestMapping("/securitiesClosedPay")
public class SecuritiesClosedPayController {
    @Resource
    SecuritiesClosedPayService securitiesClosedPayService;

    @NGULog(message="查询证券应收应付表")
    @RequestMapping("/selectSecuritiesClosedPay")
    public HashMap selectSecuritiesClosedPay(int page,int limit,String dateTime,String serviceType){
        System.out.println("xinzeng========================");
        System.out.println(dateTime);
        HashMap securitiesClosedPayMap = securitiesClosedPayService.selectSecuritiesClosedPay(page, limit,dateTime,serviceType);
        int count = (int) securitiesClosedPayMap.get("p_count");
        ArrayList<SecuritiesClosedPayPojo> securitiesClosedPayList = (ArrayList<SecuritiesClosedPayPojo>) securitiesClosedPayMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("count",count);
        hashMap.put("data",securitiesClosedPayList);
        return hashMap;
    }

    @NGULog(message="新增证券应收应付表")
    @RequestMapping("/insertSecuritiesClosedPay")
    public int insertSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo, HttpServletRequest request){
        String fundId = GetFundIdUtil.getFundId(request);
        securitiesClosedPayPojo.setFundId(fundId);
        System.out.println(securitiesClosedPayPojo);
        return securitiesClosedPayService.insertSecuritiesClosedPay(securitiesClosedPayPojo);

    }

    @NGULog(message="修改证券应收应付表")
    @RequestMapping("/updateSecuritiesClosedPay")
    public int updateSecuritiesClosedPay(SecuritiesClosedPayPojo securitiesClosedPayPojo){
        System.out.println(securitiesClosedPayPojo);
        return securitiesClosedPayService.updateSecuritiesClosedPay(securitiesClosedPayPojo);
    }

    @NGULog(message="删除证券应收应付表")
    @RequestMapping("/deleteSecuritiesClosedPay")
    public int deleteSecuritiesClosedPay(String securitiesClosedPayIds){
        System.out.println("==============");
        System.out.println(securitiesClosedPayIds);
        return securitiesClosedPayService.deleteSecuritiesClosedPay(securitiesClosedPayIds);
    }
}
