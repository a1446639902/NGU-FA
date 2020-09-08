package com.yidu.businessData.controller;

import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.businessData.service.DepositService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 存款业务表
 * @Type 控制层
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/8
 **/
@RestController
@RequestMapping("/deposit")
public class DepositController {
    @Resource
    DepositService depositService;
    @RequestMapping("/selectDeposit")
    public HashMap selectDeposit(int page,int limit,String businessType,String dateEnd){
        System.out.println(page+limit);
        System.out.println(businessType);
        System.out.println(dateEnd);
        HashMap depositMap = depositService.selectDeposit(page, limit, businessType, dateEnd);
        int count = (int) depositMap.get("p_count");
        List<DepositPojo> depositPojoList = (List<DepositPojo>) depositMap.get("p_cursor");
        HashMap hashMap = new HashMap<>();
        hashMap.put("msg","");
        hashMap.put("code",0);
        hashMap.put("count",count);
        hashMap.put("data",depositPojoList);
        return hashMap;
    }
    @RequestMapping("/insertDeposit")
    public int insertDeposit(DepositPojo depositPojo){
        System.out.println(depositPojo);
        return depositService.insertDeposit(depositPojo);
    }
    @RequestMapping("/updateDeposit")
    public int updateDeposit(DepositPojo depositPojo){
        return depositService.updateDeposit(depositPojo);
    }
    @RequestMapping("/deleteDeposit")
    public int deleteDeposit(int depositId){
        return depositService.deleteDeposit(depositId);
    }
}
