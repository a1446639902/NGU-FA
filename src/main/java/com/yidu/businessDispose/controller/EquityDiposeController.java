package com.yidu.businessDispose.controller;

import com.yidu.businessDispose.pojo.EquityDispose;
import com.yidu.businessDispose.service.impl.EquityDisposeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EquityDiposeController {
    @Resource
    EquityDisposeService equityDisposeService;

    @RequestMapping("selectEquityDispose")
    public Map<String, Object> selectEquity(String page, String limit, String equitiesType, String equitiesExright) {
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =equityDisposeService.selectEquityDispose(limit, page, equitiesType, equitiesExright);
        List<EquityDispose> equityDataList = (List<EquityDispose>) map.get("equityDataList");
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

}
