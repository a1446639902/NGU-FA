package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.Fund;
import com.yidu.businessParameter.service.FundService;
import com.yidu.permission.aspect.NGULog;
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
    @NGULog(message = "查询基金参数表")
    @RequestMapping("/selectFund")
    public HashMap selectFund(int page,int limit,String fundId,String fundType){
        //new 一个Hashmap存储状态
        HashMap fundMap = new HashMap();
        HashMap hashMap = fundService.selectFund(page,limit,fundId,fundType);
        //获取总条数
        int count = (int) hashMap.get("p_count");
        //存储过程获取游标p_cursor，返回集合
        List<Fund> fundList = (List<Fund>) hashMap.get("p_cursor");
        System.out.println("总条数："+count);
        System.out.println("page="+page+",limit="+limit+",fundId="+fundId+",fundType="+fundType);
        fundMap.put("count",count);
        fundMap.put("code",0);
        fundMap.put("msg","");
        fundMap.put("data",fundList);
        return fundMap;
    }
    @NGULog(message = "添加基金参数表")
    @RequestMapping("/insertFund")
    public int insertFund(Fund fund){
        System.out.println(fund);
        return fundService.insertFund(fund);

    }
    @NGULog(message = "删除基金参数表")
    @RequestMapping("/deleteFund")
    public int deleteFund(String fundId){
        System.out.println(fundId);
        return fundService.deleteFund(fundId);

    }
    @NGULog(message = "修改参数表")
    @RequestMapping("/updateFund")
    public int updateFund(Fund fund){
        System.out.println(fund);
        return fundService.updateFund(fund);

    }
}
