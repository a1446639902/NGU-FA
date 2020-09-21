package com.yidu.dayDispose.controller;

import com.yidu.dayDispose.service.NetValueOfStatisticalService;
import com.yidu.permission.aspect.NGULog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 净值统计表的删除控制类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@RestController
@RequestMapping("/deleteNetValueOfStatistical")
public class NetValueOfStatisticalDemoTwoController {
    @Resource
    NetValueOfStatisticalService netValueOfStatisticalService;

    @NGULog(message = "净删除值统计表")
    @RequestMapping("/deleteNetValueOfStatisticalAll")
    public void deleteNetValueOfStatistical(String time) {
        System.out.println("进入删除的控制类");
        int i = netValueOfStatisticalService.deleteNetValueOfStatistical(time);

        int i1 = netValueOfStatisticalService.deleteNetValueOfStatisticalToDay(time);
        System.out.println("删除的非当日的行数为" + i);
        System.out.println("删除的当日的行数为" + i1);
    }
}
