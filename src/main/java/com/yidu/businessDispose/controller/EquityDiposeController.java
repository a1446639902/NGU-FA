package com.yidu.businessDispose.controller;

import com.yidu.businessDispose.pojo.EquityDispose;
import com.yidu.businessDispose.service.EquityDisposeService;
import com.yidu.util.GetAccountUtil;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EquityDiposeController {
    @Resource
    EquityDisposeService equityDisposeService;

    @RequestMapping("selectEquityDispose")
    public Map<String, Object> selectEquity(String page, String limit, String equitiesType, String equitiesExright, String disposeStatus, HttpServletRequest request) {
        String accountName = GetAccountUtil.getAccountName(request);

        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =equityDisposeService.selectEquityDispose(limit, page, equitiesType, equitiesExright,disposeStatus);
        List<EquityDispose> equityDataList = (List<EquityDispose>) map.get("equityDataList");
        for (EquityDispose equityDispose : equityDataList) {
            equityDispose.setAccountName(accountName);
        }
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> EquityDisposeMap = new HashMap<>();
        EquityDisposeMap.put("code", 0);
        EquityDisposeMap.put("msg", "");
        EquityDisposeMap.put("count", count);
        EquityDisposeMap.put("data", equityDataList);
        //返回数据
        return EquityDisposeMap;
    }
    @RequestMapping("updateEquityDispose")
    public int updateEquityDispose(String equityDisPose ,HttpServletRequest request ){
        return equityDisposeService.updateEquityDispose(equityDisPose,request);
    }
    @RequestMapping("updateEquityDisposeTow")
    public int updateEquityDisposeTwo(String equityDisPose){
        return equityDisposeService.updateEquityDisposeTwo(equityDisPose);
    }
}
