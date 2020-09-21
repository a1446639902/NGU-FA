package com.yidu.businessParameter.controller;



import com.yidu.businessParameter.pojo.Bond;
import com.yidu.businessParameter.service.BondService;
import com.yidu.permission.aspect.NGULog;
import com.yidu.util.DbUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  债券信息表数的控制器 处理器
 *  @author 唐赈环
 *  @date  2020/09/01 15点32分
 *  @version 版本1.0
 */
@RestController
public class BondController {
    @Resource
    BondService bondService;
    @Resource
    DbUtil dbUtil;
    //登录验证
    @NGULog(message = "登录验证")
    @RequestMapping("/selectBond")
    public Map<String, Object> selectBond(String page, String limit, String securitiesId, String drawStartDate) {
        System.out.println(securitiesId + "," + "," + drawStartDate);
        Map<String, Object> map = bondService.selectBond(limit, page, securitiesId, drawStartDate);
        List<Bond> bondList = (List<Bond>) map.get("bondList");
        System.out.println("进来了");
        int count = (int) map.get("count");

        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", count);
        json.put("data", bondList);
        //返回数据
        return json;


    }

    @RequestMapping("/insertBond")
    public int insertBond(Bond bond) {
        System.out.println("进来了");
        System.out.println("bond=" + bond);
        int i = bondService.insertBond(bond);
        System.out.println(bond);
        return i;
    }

    @RequestMapping("/deleteBond")
    public int deleteBond(String securitiesId) {
        System.out.println("进来了");
        int a = bondService.deleteBond(securitiesId);
        return a;

    }

    @RequestMapping("/updateBond")
    public int updateBond(Bond bond) {
        System.out.println("进来了");
        System.out.println(bond);

        return bondService.updateBond(bond);
    }
}