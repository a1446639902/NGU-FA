package com.yidu.reportManage.controller;

import com.yidu.permission.aspect.NGULog;
import com.yidu.reportManage.pojo.StatementMarketChangePojo;
import com.yidu.reportManage.service.StatementMarketChangeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 证券市场变动表
 * @author 黄志豪
 * @version 1.0
 * @Type 控制层
 * @time 2020/9/20
 **/
@RestController
@RequestMapping
public class StatementMarketChangeController {
    @Resource
    StatementMarketChangeService statementMarketChangeService;

    /**
     * 查询证券市场变动表
     * @param dateTime 日期
     * @return 返回hashMap对象
     */
    @NGULog(message="查询证券市场变动表")
    @RequestMapping("/selectStatementMarketChange")
    public HashMap selectStatementMarketChange(String dateTime){
        //调用服务层的查询方法
        HashMap hashMap = statementMarketChangeService.selectStatementMarketChange(dateTime);
        //获取hashMap中的p_count，p_cursor的值，进行强转
        int count = (int) hashMap.get("count");
        ArrayList<StatementMarketChangePojo> smcpList = (ArrayList<StatementMarketChangePojo>) hashMap.get("list");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap<Object, Object> smcMap = new HashMap<>();
        smcMap.put("code",0);
        smcMap.put("msg","");
        smcMap.put("count",count);
        smcMap.put("data",smcpList);
        return smcMap;

    }
}
