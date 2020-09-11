package com.yidu.dayDispose.controller;

import com.yidu.dayDispose.pojo.NetValueOfStatisticalPojo;
import com.yidu.dayDispose.service.NetValueOfStatisticalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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
        List<NetValueOfStatisticalPojo> NetValueOfStatisticalList = netValueOfStatisticalService.selectNetValueOfStatistical();
        Map<String,Object> map = new HashMap();
        //响应头
        map.put("msg","");
        map.put("code",0);
        map.put("count",null);
        map.put("date",NetValueOfStatisticalList);
        System.out.println(map);
        return map;
    }
}
