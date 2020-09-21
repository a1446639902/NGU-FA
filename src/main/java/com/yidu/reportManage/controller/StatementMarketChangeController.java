package com.yidu.reportManage.controller;

import com.yidu.reportManage.pojo.StatementMarketChangePojo;
import com.yidu.reportManage.service.StatementMarketChangeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/20
 **/
@RestController
@RequestMapping
public class StatementMarketChangeController {
    @Resource
    StatementMarketChangeService statementMarketChangeService;
    @RequestMapping("/selectStatementMarketChange")
    public HashMap selectStatementMarketChange(String dateTime){
        HashMap hashMap = statementMarketChangeService.selectStatementMarketChange(dateTime);
        int count = (int) hashMap.get("count");
        ArrayList<StatementMarketChangePojo> smcpList = (ArrayList<StatementMarketChangePojo>) hashMap.get("list");

        HashMap<Object, Object> smcMap = new HashMap<>();
        smcMap.put("code",0);
        smcMap.put("msg","");
        smcMap.put("count",count);
        smcMap.put("data",smcpList);
        return smcMap;

    }
}
