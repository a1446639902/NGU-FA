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
 * 查询净值统计表的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@RestController
@RequestMapping("/selectTable")
public class NetValueOfStatisticalDemoOneController {
    @Resource
    NetValueOfStatisticalService netValueOfStatisticalService;

    @RequestMapping("/selectTableByTime")
    public Map<String, Object> selectNetValueOfStatisticalController(String time) {
        netValueOfStatisticalService.selectAllMsg(time);
        //查询插入的数据
        System.out.println("从界面接收到的时间数据是" + time);
        List<NetValueOfStatisticalPojo> NetValueOfStatisticalList = netValueOfStatisticalService.selectNetValueOfStatistical(time);
        Map<String, Object> map = new HashMap();
        //响应头
        map.put("msg", "");
        map.put("code", 0);
        map.put("count", 10);
        map.put("data", NetValueOfStatisticalList);
        System.out.println("查询出来的基金统计的结果集合是" + map);
        return map;
    }
}
