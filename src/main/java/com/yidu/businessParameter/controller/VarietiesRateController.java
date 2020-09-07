package com.yidu.businessParameter.controller;

import com.yidu.businessParameter.pojo.VarietiesRatePojo;
import com.yidu.businessParameter.service.VarietiesRateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName VarietiesRateController
 * @Description: TODO
 * @Author 硠君
 * @Date create in 14:42 2020/9/2
 * @Version 1.0
 **/
@RestController
public class VarietiesRateController {
    @Resource
    VarietiesRateService varietiesRateService;

 //删除方法
    @RequestMapping("deleteVarietiesRate")
    public int deleteVarietiesRate(String exchangeNames,String rateTypes){
        System.out.println("进入删除controller了");
        int i = varietiesRateService.deleteVarietiesRate(exchangeNames,rateTypes);
        return i;
    }

    //增加controller
    @RequestMapping("insertVarietiesRate")
    public int insertVarietiesRate(VarietiesRatePojo varietiesRatePojo){
        System.out.println("进入了增加controller了");
        int i=varietiesRateService.insertVarietiesRate(varietiesRatePojo);
        return i;
    }
    //修改controller
    @RequestMapping("updateVarietiesRate")
    public int updateVarietiesRate(VarietiesRatePojo varietiesRatePojo){
        System.out.println("进入了修改controller了");
        int i=varietiesRateService.updateVarietiesRate(varietiesRatePojo);
        return i;
    }
//    查询controller
    @RequestMapping("selectVarietiesRate")
    public Map<String,Object> selectVarieties(String page,String limit,String exchangeName,String rateType){
        System.out.println("进入了查询Controller");
        //调用Service层 返回结果集map
        Map<String,Object> map =varietiesRateService.selectVarietiesRate(limit,page,exchangeName,rateType);
        //从结果集中拿出结果
        //接收返回数据
        List<VarietiesRatePojo> varietiesRates= (List<VarietiesRatePojo>) map.get("varietiesRates");
        //接收返回总条数
        int count= (int) map.get("count");
        //以layui要求存储响应数据格式
        Map<String, Object> json = new HashMap<>();
        json.put("code",0);
        json.put("msg","");
        json.put("count",count);
        json.put("data",varietiesRates);
        //返回数据
        return json;
    }
}
