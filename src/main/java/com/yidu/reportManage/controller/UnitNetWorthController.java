package com.yidu.reportManage.controller;

import com.yidu.permission.aspect.NGULog;
import com.yidu.reportManage.service.UnitNetWorthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName UnitNetWorthController
 * @Description: TODO
 * @Author 硠君
 * @Date create in 14:19 2020/9/19
 * @Version 1.0
 **/
@RestController
public class UnitNetWorthController {
    @Resource
    UnitNetWorthService unitNetWorthService;
    @NGULog(message = "单位净值折线图")//事务管理
    @RequestMapping("lineChart")
    public Map<String,Object> lineChart(String month){
        List<Double> lineChartList = unitNetWorthService.lineChart(month);
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count","");
        json.put("data",lineChartList);
        //返回数据
        return json;
    }
}
