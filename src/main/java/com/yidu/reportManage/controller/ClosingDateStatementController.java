package com.yidu.reportManage.controller;

import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.permission.aspect.NGULog;
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

    /**
     * 查询成交结算日报表的方法
     * @param page 页码
     * @param limit 每页的条数
     * @param dateTime 日期
     * @return 返回hashMap对象
     */
    @NGULog(message="查询成交结算日报表")
    @RequestMapping("/selectClosingDateStatement")
    public HashMap selectClosingDateStatement(int page,int limit,String dateTime){
        //调用服务层的查询方法
        HashMap cdsMap = closingDateStatementService.selectClosingDateStatement(dateTime);
        //获取cdsMap中的p_count，p_cursor的值，进行强转
        int count = (int) cdsMap.get("count");
        ArrayList<ClosingDateStatementPojo> closingDateList = (ArrayList<ClosingDateStatementPojo>) cdsMap.get("list");
        //返回前端页面格式数据（"msg","code","count","data"）
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",closingDateList);
        return hashMap;
    }
}
