package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.dayDispose.service.RevenueProvisionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("RevenueProvision")
public class RevenueProvisionController {
    @Resource
    RevenueProvisionService revenueProvisionService;
    @RequestMapping("selectRevenueProvision")
    public HashMap selectRevenueProvision(int page, int limit,String businessDate){
        System.out.println(businessDate);
        HashMap hashMap = revenueProvisionService.selectRevenueProvision(page, limit);
        int count = (int)hashMap.get("p_count");
        List<RevenueProvision> revenueProvisionList = (List<RevenueProvision>)hashMap.get("p_cursor");
        System.out.println(revenueProvisionList);
        HashMap revenueProvisionMap = new HashMap();
        revenueProvisionMap.put("code",0);
        revenueProvisionMap.put("count",count);
        revenueProvisionMap.put("msg","");
        revenueProvisionMap.put("data",revenueProvisionList);
        return revenueProvisionMap;
    }
}
