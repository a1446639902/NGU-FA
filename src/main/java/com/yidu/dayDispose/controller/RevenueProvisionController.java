package com.yidu.dayDispose.controller;

import com.yidu.businessData.pojo.MarketData;
import com.yidu.dayDispose.pojo.BondInterest;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.dayDispose.pojo.TwoFees;
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
    private String statDate;

    @RequestMapping("selectRevenueProvision")
    public HashMap selectRevenueProvision(int page, int limit,String statDate){
        this.statDate=statDate;
        HashMap hashMap = revenueProvisionService.selectRevenueProvision(page, limit,statDate);
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
    @RequestMapping("selectBondInterest")
    public HashMap selectBondInterest(int page ,int limit,String statDate){
        System.out.println("第二个"+this.statDate);
        HashMap hashMap = revenueProvisionService.selectBondInterest(page, limit ,statDate);
        int count = (int)hashMap.get("p_count");
        List<BondInterest> bondInterestList = (List<BondInterest>)hashMap.get("p_cursor");
        System.out.println(bondInterestList);
        HashMap bondInterestMap = new HashMap();
        bondInterestMap.put("code",0);
        bondInterestMap.put("count",count);
        bondInterestMap.put("msg","");
        bondInterestMap.put("data",bondInterestList);
        return bondInterestMap;
    }
    @RequestMapping("selectTwoFees")
    public HashMap selectTwoFees(int page ,int limit,String statDate){
        System.out.println("第三个"+this.statDate);
        HashMap hashMap = revenueProvisionService.selectTwoFees(page, limit, statDate);
        System.out.println(statDate+"=============================");
        int count = (int)hashMap.get("p_count");
        List<TwoFees> twoFeesList = (List<TwoFees>)hashMap.get("p_cursor");
        System.out.println(twoFeesList);
        HashMap twoFeesMap = new HashMap();
        twoFeesMap.put("code",0);
        twoFeesMap.put("count",count);
        twoFeesMap.put("msg","");
        twoFeesMap.put("data",twoFeesList);
        return twoFeesMap;
    }
}
