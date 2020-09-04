package com.yidu.businessParameter.controller;


import com.yidu.businessParameter.pojo.BondPojo;
import com.yidu.businessParameter.service.BondService;
import com.yidu.taManage.pojo.TaTransactionPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    //增
    @RequestMapping("/insertBond")
    public int insertBond(BondPojo bondPojo){
        System.out.println("进来了");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss ");
        Date date = new Date(System.currentTimeMillis());
        String format = formatter.format(date);
        BondPojo bondPojo1 = new BondPojo("1","1","2020/02/20","2020/02/20",1,3.5,3.6,"20000",3,"人傻钱多");
        int i= bondService.insertBond(bondPojo);
        return i;
    }
    //删除
    @RequestMapping("/deleteBond")
    public void deleteBond(){
        bondService.deleteBond(1);
    }
    //修改
    @RequestMapping("/updateBond")
    public int updateBond(){
        BondPojo bondPojo2 = new BondPojo("1","1","2020/02/20","2020/02/20",1,3.5,3.6,"20000",3,"人傻钱多");
        int b = bondService.updateBond(bondPojo2);
        return b;
    }

    //查
    @RequestMapping("/selectBond")
    public HashMap selectBond(String page, String limit){
        Map<String,Object> map=bondService.selectBond(limit, page);
        List<BondPojo> bondPojoList= (List<BondPojo>) map.get("bondPojoList");
        int count = (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> bond = new HashMap<>();
        bond.put("code",0);
        bond.put("msg","");
        bond.put("count",count);
        bond.put("data",bondPojoList);
        //返回数据\
        return (HashMap) bond;
    }
}
