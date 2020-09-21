package com.yidu.permission.controller;


import com.yidu.permission.aspect.NGULog;
import com.yidu.permission.pojo.Trustee;
import com.yidu.permission.service.TrusteeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author cai
 * 托管银行
 */
@RestController
@RequestMapping("trustee")
public class TrusteeController {
    @Resource
    TrusteeService trusteeService;
    @NGULog(message = "查询托管人")
    @RequestMapping("selectTrustee")
    public HashMap selectTrustee(){
        List<Trustee> trusteeList = trusteeService.selectTrustee();
        HashMap hashMap = new HashMap();
        hashMap.put("count",0);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",trusteeList);
        return hashMap;
    }
}
