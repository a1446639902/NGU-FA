package com.yidu.businessParameter.controller;


import com.yidu.businessParameter.pojo.BondPojo;
import com.yidu.businessParameter.service.BondService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
    //增
    @RequestMapping("/insertBond")
    public int insertBond(BondPojo bondPojo){
        return bondService.insertBond(bondPojo);
    }
    //删除
    @RequestMapping("/deleteBond")
    public int deleteBond(String securitiesId){
        return bondService.deleteBond(securitiesId);
    }
    //修改
    @RequestMapping("/updateBond")
    public int updateBond(BondPojo bondPojo){
        return bondService.updateBond(bondPojo);
    }

    //查
    @RequestMapping("/selectBond")
    public HashMap selectBond(){
        List<BondPojo> bondPojoList = bondService.selectBond();
        HashMap bondMap= new HashMap();
        bondMap.put("count",10);
        bondMap.put("code",0);
        bondMap.put("msg","");
        bondMap.put("data",bondPojoList);
        return bondMap;
    }
}
