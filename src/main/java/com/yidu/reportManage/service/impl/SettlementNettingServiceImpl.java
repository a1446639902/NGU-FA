package com.yidu.reportManage.service.impl;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.reportManage.mapper.SettlementNettingMapper;
import com.yidu.reportManage.pojo.SettlementNettingPojo;
import com.yidu.reportManage.service.SettlementNettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName SettlementNettingServiceImpl
 * @Description: TODO
 * @Author 硠君
 * @Date create in 17:45 2020/9/18
 * @Version 1.0
 **/
@Service
@Transactional
public class SettlementNettingServiceImpl implements SettlementNettingService {
    @Resource
    SettlementNettingMapper settlementNettingMapper;
    @Override
    public Map<String,Object>  selectTable(String pageSize, String page,String dateTime) {
        System.out.println("dateTime:="+dateTime);
//        创建一个结果集用于接收返回结果
        Map<String,Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize=0;
        //判断传入的pageSize是否为null/空
        if (pageSize!=null && !pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize= Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page=0;
        //判断传入的page是否为null/空
        if(page!=null&&!page.equals("")) {
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }
        if (dateTime!=null && !dateTime.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date today=new Date();
            dateTime = sdf.format(today);
        }
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","cashClosedPay c join fund f on f.fundId=c.fundId join account a on a.accountId=c.accountId");
        map.put("p_condition","");
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);
        //调用Mapper执行查询
        settlementNettingMapper.selectTable(map);
        System.out.println(map.get("p_cursor"));
        //接收返回数据
        List<SettlementNettingPojo> settlementNetting = (List<SettlementNettingPojo>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("settlementNetting",settlementNetting);
        resultMap.put("count",count);
        return resultMap;
    }
}
