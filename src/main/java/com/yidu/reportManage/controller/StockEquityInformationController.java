package com.yidu.reportManage.controller;


import com.yidu.reportManage.pojo.StockEquityInformationPojo;
import com.yidu.reportManage.service.StockEquityInformationServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**股票信息Service
 *author xbf
 * 2020-9-18
 **/
@RestController
public class StockEquityInformationController {
    @Resource
    StockEquityInformationServices stockEquityInformationServices;
    @RequestMapping("/selectStockEquityInformation")
    public HashMap selectStockEquityInformation(int page, int limit, String issueDate){
        HashMap hashMap=stockEquityInformationServices.selectStockEquityInformation(page,limit,issueDate);
        int count = (int) hashMap.get("p_count");
        List<StockEquityInformationPojo> stockEquityInformationList = (List<StockEquityInformationPojo>) hashMap.get("list");
        HashMap seiMap=new HashMap();
        seiMap.put("count",count);
        seiMap.put("code",0);
        seiMap.put("msg","");
        seiMap.put("data",stockEquityInformationList);
        return seiMap;
    }
}
