package com.yidu.businessParameter.controller;

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
    @RequestMapping("/insert")
    public boolean insert(Brokers  brokers){
//        brokers.setBrokersId("10");
//        brokers.setBrokersName("中国石油");
//        brokers.setBrokersInstructions("汽油");
//        brokers.setDesc("上涨");
       return brokersService.insert(brokers);
    }


    /**
     * 删除
     * @param brokersId
     * @return
     */
    @RequestMapping("/delete")
    public String delete(String brokersId){
        brokersService.delete("10");
        return "删除成功";
    }


    /**
     * 修改
     * @param brokers
     * @return
     */
    @RequestMapping("/update")
    public boolean update(Brokers brokers){
        brokers.setBrokersId("10");
        brokers.setBrokersName("中国石化");
        brokers.setBrokersInstructions("92汽油");
        brokers.setBrokersDesc("下降");
        return brokersService.update(brokers);
    }


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/select")
    public HashMap select(){
        List<Brokers> brokers=brokersService.select();
        HashMap hashMap=new HashMap();
        hashMap.put("code",0);
        hashMap.put("data",brokers);
        System.out.println("查询");
        return hashMap;
    }
//    public List<Brokers> select(){
//        System.out.println("查询");
//        List<Brokers> brokersList = brokersService.select();
//        return brokersList;
//    }
}
