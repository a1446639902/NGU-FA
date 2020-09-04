package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.CashClosedPayMapper;
import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.service.CashClosedPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName CashClosePayServiceImpl
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:53 2020/9/1
 * @Version 1.0
 **/
@Service
public class CashClosedPayServiceImpl implements CashClosedPayService {
    @Resource
    CashClosedPayMapper cashClosedPayMapper;

    @Override
    public int insertCashClosedPay(CashClosedPayPojo cashClosedPay) {
        return cashClosedPayMapper.insertCashClosedPay(cashClosedPay);
    }

    @Override
    public int deleteCashClosedPay(String cashClosedPayId) {
        return cashClosedPayMapper.deleteCashClosedPay(cashClosedPayId);
    }

    @Override
    public int updateCashClosedPay(CashClosedPayPojo cashClosedPay) {
        return cashClosedPayMapper.updateCashClosedPay(cashClosedPay);
    }

    @Override
    public Map<String,Object> selectCashClosedPay(String pageSize, String page) {
//创建一个结果集用于接受存储过程的返回结果
        Map<String,Object> resultMap = new HashMap<>();
        //存储过程所需条件为p_tableName/p_condition/p_page/p_pageSize/p_count/p_cursor
        //定义一个分页条数变量
        int v_pageSize=0;
        //判断传入的pageSize是否为null/空
        if (pageSize!=null && pageSize.equals("")){
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
//创建一个结果集用于接收数据库存储过程所需条件
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","cashClosedPay");
        map.put("p_condition","");
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);

        //调用Mapper执行查询
        cashClosedPayMapper.selectCashClosedPay(map);
        //接收返回数据
        List<CashClosedPayPojo> cashClosedPays = (List<CashClosedPayPojo>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("cashClosedPays",cashClosedPays);
        resultMap.put("count",count);
        return resultMap;
    }
}
