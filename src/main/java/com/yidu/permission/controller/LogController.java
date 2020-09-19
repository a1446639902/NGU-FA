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
    public HashMap selectLog(int page, int limit, String userName){
        HashMap logMap = logService.selectLog(page, limit, userName);
        int count = (int) logMap.get("p_count");
        List<Log> logList = (List<Log>) logMap.get("p_cursor");
        HashMap hashMap = new HashMap();
        hashMap.put("count",count);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",logList);
        return hashMap;
    }
}
