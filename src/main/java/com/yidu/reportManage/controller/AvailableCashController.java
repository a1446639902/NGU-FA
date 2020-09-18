package com.yidu.reportManage.controller;

import com.yidu.dayDispose.pojo.InventoryEntity;
import com.yidu.reportManage.pojo.AvailableCashEntity;
import com.yidu.reportManage.service.AvailableCashPositionTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报表管理：现金头寸报表的控制层
 * date：2020/9/18
 * @Mr.Zou
 **/
@RestController
public class AvailableCashController {

    //得到现金头寸报表的service层
    @Resource
    AvailableCashPositionTableService availableCashPositionTableService;

    @RequestMapping("/AvailableCashController")
    public Map<String,Object> selectInventory(String page, String limit, String dateTime){

        //调用Service层执行查询，接收返回结果集Map
        Map<String, Object> map = availableCashPositionTableService.selectAvailable(limit,page,dateTime);
        System.out.printf("我获得的数据："+map.toString());

        //从结果集中拿出结果
        List<AvailableCashEntity> availableCashPositionTableList = (List<AvailableCashEntity>) map.get("availableCashPositionTableList");
        int count = (int) map.get("count");

        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",availableCashPositionTableList);
        //返回Map集合 数据
        return json;
    }


}
