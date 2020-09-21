package com.yidu.permission.controller;

import com.yidu.permission.aspect.NGULog;
import com.yidu.permission.pojo.Manager;
import com.yidu.permission.service.ManagerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author cai
 * 管理人
 */
@RestController
@RequestMapping("manager")
public class ManagerController {
    @Resource
    ManagerService managerService;
    @NGULog(message = "查询管理人")
    @RequestMapping("selectManager")
    public HashMap selectManager(){
        List<Manager> managerList = managerService.selectManager();
        HashMap hashMap = new HashMap();
        hashMap.put("count",0);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",managerList);
        return hashMap;
    }
}
