package com.yidu.reportManage.controller;

import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.reportManage.pojo.ClosingDateStatementPojo;
import com.yidu.reportManage.service.ClosingDateStatementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 成交结算日报表
 * @author 黄志豪
 * @version 1.0
 * @Type 控制层
 * @time 2020/9/16
 **/
@RestController
public class ClosingDateStatementController {
    @Resource
    ClosingDateStatementService closingDateStatementService;
    @RequestMapping("/selectClosingDateStatement")
    public HashMap selectClosingDateStatement(int page,int limit,String dateTime){
        System.out.println("--------------------");
        HashMap cdsMap = closingDateStatementService.selectClosingDateStatement(page, limit, dateTime);
        int count = (int) cdsMap.get("p_count");
        ArrayList<ClosingDateStatementPojo> closingDateList = (ArrayList<ClosingDateStatementPojo>) cdsMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",closingDateList);
        return hashMap;
    }
}