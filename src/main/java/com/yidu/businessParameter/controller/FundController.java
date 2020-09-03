package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.Fund;
import com.yidu.businessParameter.service.FundService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 基金参数
 * @Type:控制层
 * @author Tmac
 * @time 2020/9/1  9:13
 * @version   1.1
 **/
@RestController
@RequestMapping("/fund")
public class FundController {
    @Resource
    FundService fundService;
    @RequestMapping("/selectFund")
    public HashMap selectFund(int page,int limit){
        HashMap fundMap = new HashMap();
        HashMap hashMap = fundService.selectFund(page, limit);
        int count = (int) hashMap.get("p_count");
        List<Fund> fundList = (List<Fund>) hashMap.get("p_cursor");
        System.out.println("总条数："+count);
        System.out.println("page="+page+",limit="+limit);
        fundMap.put("count",count);
        fundMap.put("code",0);
        fundMap.put("msg","");
        fundMap.put("data",fundList);
        return fundMap;
    }
    @RequestMapping("/insertFund")
    public int insertFund(Fund fund){
        System.out.println(fund);
        fund.setManagerId("111111");
        fund.setTrusteeBlank("111111");
        return fundService.insertFund(fund);

    }
    @RequestMapping("/deleteFund")
    public int deleteFund(String fundId){
        System.out.println(fundId);
        return fundService.deleteFund(fundId);

    }

    @RequestMapping("/updateFund")
    public int updateFund(Fund fund){
        System.out.println(fund);
        return fundService.updateFund(fund);

    }
}
