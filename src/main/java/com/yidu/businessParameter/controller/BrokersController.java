package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.AccountPojo;
import com.yidu.businessParameter.pojo.Brokers;
import com.yidu.businessParameter.service.BrokersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @name 戴言露
 * @data 2020/9/2 pm
 *券商信息表控制层
 */

@RestController
public class BrokersController {
    @Autowired
    private BrokersService brokersService;

    /**
     * 增加
     */
    @RequestMapping("/brokersInsert")
    public int insert(Brokers  brokers){
        System.out.println("增加成功");
       return brokersService.insert(brokers);
    }


    /**
     * 删除
     * @param brokersId
     * @return
     */
    @RequestMapping("/brokersDelete")
    public int delete(String brokersId){
        System.out.println(brokersId);
         return brokersService.brokersDelete(brokersId);
    }


    /**
     * 修改
     * @param brokers
     * @return
     */
    @RequestMapping("/brokersUpdate")
    public int update(Brokers brokers){
        return brokersService.update(brokers);
    }


    /**
     * 查询
     * @return
     */
    @RequestMapping("/brokersSelect")
    public HashMap brokersSelect(int page,int limit,String brokersName) {
        System.out.println("进来了");
        System.out.println(page+","+limit+","+brokersName);
        HashMap hashMap = brokersService.brokersSelect(page,limit,brokersName);
        int count = (int) hashMap.get("p_count");
        List<Brokers> brokersList = (List<Brokers>) hashMap.get("p_cursor");
        HashMap brokersMap = new HashMap();
        brokersMap.put("count",count);
        brokersMap.put("code", 0);
        brokersMap.put("msg", "");
        brokersMap.put("data", brokersList);
        return brokersMap;
    }

}
