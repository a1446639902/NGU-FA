package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.Brokers;
import com.yidu.businessParameter.pojo.Seate;
import com.yidu.businessParameter.service.BrokersService;
import com.yidu.businessParameter.service.SeateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @name 戴言露a
 * @data 2020/9/5 am
 *席位信息表控制层
 */

@RestController
public class SeateController {
    @Autowired
    private SeateService seateService;

    /**
     * 增加
     * @param seate
     * @return
     */
    @RequestMapping("/seateInsert")
    public int seateInsert(Seate seate){
        System.out.println("增加成功");
        return seateService.seateInsert(seate);
    }


    /**
     * 删除
     * @param seateId
     * @return
     */
    @RequestMapping("/seateDelete")
    public int delete(String seateId){
        System.out.println(seateId);
        return seateService.seateDelete(seateId);
    }


    /**
     * 修改
     * @param seate
     * @return
     */
    @RequestMapping("/seateUpdate")
    public int seateUpdate(Seate seate){
        System.out.println("BrokersId"+seate.getBrokersId());
        return seateService.seateUpdate(seate);
    }


    /**
     * 查询
     * @return
     */
    @RequestMapping("/seateSelect")
    public HashMap seateSelect(String page, String limit, String seateName,String brokersId,String modules) {
        System.out.println("进来了");
        System.out.println(page+","+limit+","+seateName);
        System.out.println("modules"+modules);
        int page1 = Integer.parseInt(page);
        int limit1 = Integer.parseInt(limit);
        HashMap hashMap = seateService.seateSelect(page1,limit1,seateName,brokersId,modules);
        int count = (int) hashMap.get("p_count");
        List<Seate> seateList = (List<Seate>) hashMap.get("p_cursor");
        HashMap seateMap = new HashMap();
        seateMap.put("count",count);
        seateMap.put("code", 0);
        seateMap.put("msg", "");
        seateMap.put("data", seateList);
        return seateMap;
    }
}
