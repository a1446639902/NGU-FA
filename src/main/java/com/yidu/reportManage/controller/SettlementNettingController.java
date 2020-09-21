package com.yidu.reportManage.controller;

import com.yidu.reportManage.pojo.SettlementNettingPojo;
import com.yidu.reportManage.service.SettlementNettingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName SettlementNettingController
 * @Description: TODO
 * @Author 硠君
 * @Date create in 18:44 2020/9/18
 * @Version 1.0
 **/
@RestController
public class SettlementNettingController {
    @Resource
    SettlementNettingService settlementNettingService;
    @RequestMapping("selectTable")
    public Map<String,Object> selectTable(String page, String limit,String dateTime){
        System.out.println("进入了报表控制层===================");
        Map map = settlementNettingService.selectTable(limit, page, dateTime);
        List<SettlementNettingPojo> SettlementNettings= (List<SettlementNettingPojo>)map.get("settlementNetting");
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",SettlementNettings);
        //返回数据
        return json;
    }
}
