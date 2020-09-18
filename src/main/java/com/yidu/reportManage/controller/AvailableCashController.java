package com.yidu.reportManage.controller;

import com.yidu.dayDispose.pojo.InventoryEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 报表管理：现金头寸报表的控制层
 * date：2020/9/18
 * @Mr.Zou
 **/
@RestController
public class AvailableCashController {

    @RequestMapping("/AvailableCashController")
    public HashMap selectInventory(String dateTime){

        System.out.println("我获得的数据为："+dateTime);

        HashMap userMap = new HashMap();
        userMap.put("count",10);
        userMap.put("code",0);
        userMap.put("msg","");
        userMap.put("data",null);
        return userMap;
    }


}
