package com.yidu.reportManage.controller;

import com.yidu.reportManage.service.SettlementNettingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    public Map selectTable(Map map){
        System.out.println("进入了报表控制层===================");

        return map;
    }
}
