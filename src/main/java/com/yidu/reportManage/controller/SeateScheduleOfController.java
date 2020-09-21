package com.yidu.reportManage.controller;

import com.yidu.businessParameter.pojo.Brokers;
import com.yidu.reportManage.pojo.SeateScheduleOf;
import com.yidu.reportManage.service.SeateScheduleOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @name 戴言露
 * @data 2020/9/18 pm
 *券商信息表实现层
 */
@RestController
public class SeateScheduleOfController {
    @Autowired
    private SeateScheduleOfService seateScheduleOfService;
    @RequestMapping("/selectSeateScheduleOf")
    public HashMap selectSeateScheduleOf(int page, int limit, String fundName){
        System.out.println(page+","+limit+","+fundName);
        HashMap hashMap = seateScheduleOfService.selectSeateScheduleOf(page,limit,fundName);
        int count = (int) hashMap.get("p_count");
        List<SeateScheduleOf> seateScheduleOfList = (List<SeateScheduleOf>) hashMap.get("p_cursor");
        HashMap seateScheduleOfMap = new HashMap();
        seateScheduleOfMap.put("count",count);
        seateScheduleOfMap.put("code", 0);
        seateScheduleOfMap.put("msg", "");
        seateScheduleOfMap.put("data", seateScheduleOfList);
        return seateScheduleOfMap;
    }
}
