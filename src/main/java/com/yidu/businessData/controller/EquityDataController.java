package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.EquityData;
import com.yidu.businessData.service.EquityDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置控制层
 */

@RestController
@RequestMapping("/EquityData")
public class EquityDataController {
    @Resource
    EquityDataService equityDataService;
    @RequestMapping("/selectEquityData")
    public HashMap selectEquityDataMapper(){
        List<EquityData> equityDataList = equityDataService.selectEquityDataMapper();
        HashMap hashMap = new HashMap();
        hashMap.put("count",10);
        hashMap.put("code",0);
        hashMap.put("msg","");
        hashMap.put("data",equityDataList);
        return hashMap;
    }

}
