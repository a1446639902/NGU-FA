package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.EquityData;
import com.yidu.businessData.service.EquityDataService;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置控制层
 */

@RestController
public class EquityDataController {
    @Resource
    EquityDataService equityDataService;
    @Resource
    DbUtil dbUtil;

    @RequestMapping("insertEquityData")
    public int insertEquityData(EquityData equityData) {
        equityData.setEquityDataId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.ED));
        equityData.setEquityDataId(DateTimeUtil.getSystemDateTime("yyyy-MM-dd"));
        int i = equityDataService.insertEquityData(equityData);
        return i;
    }

    @RequestMapping("deleteEquityData")
    public int deleteEquityData(String equityDataId) {
        int i = equityDataService.deleteEquityData(equityDataId);
        return i;
    }

    @RequestMapping("updateEquityData")
    public int updateEquityData(EquityData equityData) {
        System.out.println(equityData);
        int i = equityDataService.updateEquityData(equityData);
        return i;
    }

    @RequestMapping("selectEquityData")
    public Map<String, Object> selectEquityData(String page, String limit,String equitiesType,String equitiesExright) {
        System.out.println(equitiesType);
        System.out.println(equitiesExright);
        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = equityDataService.selectEquityData(limit, page,equitiesType,equitiesExright);
        List<EquityData> equityDataList = (List<EquityData>) map.get("equityDataList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> equityDataMap = new HashMap<>();
        equityDataMap.put("code", 0);
        equityDataMap.put("msg", "");
        equityDataMap.put("count", count);
        equityDataMap.put("data", equityDataList);
        //返回数据
        return equityDataMap;
    }

}
