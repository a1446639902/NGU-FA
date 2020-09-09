package com.yidu.dayDispose.controller;

import com.yidu.dayDispose.service.NetValueOfStatisticalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 净值统计的控制类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@RestController
@RequestMapping("/NetValueOfStatistical")
public class NetValueOfStatisticalController {
    @Resource
    NetValueOfStatisticalService netValueOfStatisticalService;

    @RequestMapping("/selectNetValueOfStatisticalController")
    public Map<String,Object> selectNetValueOfStatisticalController(){
        HashMap hashMap = netValueOfStatisticalService.selectNetValueOfStatistical();
        Map<String,Object> map = new HashMap();
        //响应头
        map.put("msg","");
        map.put("code",0);
        //查询出来的条数
        map.put("count",hashMap.get("p_count"));
        //需要传递的游标变量
        map.put("date",hashMap.get("p_cursor"));
        System.out.println(map);
        return map;
    }
}
