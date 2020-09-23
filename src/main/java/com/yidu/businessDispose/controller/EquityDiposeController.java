package com.yidu.businessDispose.controller;

import com.yidu.businessDispose.pojo.EquityDispose;
import com.yidu.businessDispose.service.EquityDisposeService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.GetAccountUtil;
import com.yidu.util.GetFundIdUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *@author wzh
 *date 2020-9-21
 * 权益处理设置控制层
 */
@RestController
public class EquityDiposeController {
    /**
     * 调用权益数据的服务层Service
     */
    @Resource
    EquityDisposeService equityDisposeService;

    /**
     * 权益处理查询方法
     * @param page
     * @param limit
     * @param equitiesType
     * @param equitiesExright
     * @param disposeStatus
     * @param request
     * @return
     */
    @NGULog(message = "权益处理查询方法")
    @RequestMapping("selectEquityDispose")
    public Map<String, Object> selectEquity(String page, String limit, String equitiesType, String equitiesExright, String disposeStatus, HttpServletRequest request) {
        String accountName = GetAccountUtil.getAccountName(request);

        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map =equityDisposeService.selectEquityDispose(limit, page, equitiesType, equitiesExright,disposeStatus);
        List<EquityDispose> equityDataList = (List<EquityDispose>) map.get("equityDisposeList");
        for (EquityDispose equityDispose : equityDataList) {
            equityDispose.setAccountName(accountName);
        }
        System.out.println(equityDataList);
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

    /**
     * 权益处理修改状态插入交易数据
     * @param equityDisPose
     * @param request
     * @return
     */
    @NGULog(message = "权益处理修改状态插入交易数据")
    @RequestMapping("updateEquityDispose")
    public int updateEquityDispose(String equityDisPose ,HttpServletRequest request ){
        return equityDisposeService.updateEquityDispose(equityDisPose,request);
    }

    /**
     * 权益处理修改方法
     * @param equityDisPose
     * @return
     */
    @NGULog(message = "权益处理修改方法")
    @RequestMapping("updateEquityDisposeTow")
    public int updateEquityDisposeTwo(String equityDisPose){
        return equityDisposeService.updateEquityDisposeTwo(equityDisPose);
    }
}
