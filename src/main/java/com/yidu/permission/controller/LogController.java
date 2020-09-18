package com.yidu.permission.controller;

import com.yidu.permission.pojo.Log;
import com.yidu.permission.service.LogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class LogController {
    @Resource
    LogService logService;
    @RequestMapping("selectLog")
    public HashMap selectLog(){
        HashMap hashMap = new HashMap();
        List<Log> logList = logService.selectLog();
        hashMap.put("count",0);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",logList);
        return hashMap;
    }
}
