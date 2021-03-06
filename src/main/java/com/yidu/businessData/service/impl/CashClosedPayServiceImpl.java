package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.CashClosedPayMapper;
import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.businessData.service.CashClosedPayService;
import com.yidu.dayDispose.pojo.RevenueProvision;
import com.yidu.util.DbUtil;
import com.yidu.util.GetFundIdUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@Transactional
public class CashClosedPayServiceImpl implements CashClosedPayService {
    @Resource
    CashClosedPayMapper cashClosedPayMapper;
    @Resource
    DbUtil dbUtil;

/**
* @author 硠君
* @Description 现金应收应付的新增方法
* @Date 15:03 2020/9/22
* @Parm [cashClosedPay, request]
* @return int
**/

    @Override
    public int insertCashClosedPay(CashClosedPayPojo cashClosedPay,HttpServletRequest request) {
//        System.out.println("新增的cashClosedPay:="+cashClosedPay);
        if (cashClosedPay.getCashClosedPayId() ==null || cashClosedPay.getCashClosedPayId().equals("")) {
            //得到当天当前数据表中的最大Id
            String cashClosedPayId = dbUtil.requestDbTableMaxId(SysTableNameListUtil.CCP);
            //将获得的最大id赋值给实体类中，作为参数调用sql语句
            cashClosedPay.setCashClosedPayId(cashClosedPayId);
        }
        if (cashClosedPay.getFundId()==null || cashClosedPay.getFundId().equals("")) {
            //得到请求中的session中的fundId
            String fundId = GetFundIdUtil.getFundId(request);
            //将得到的fundId赋值到实体类中
            cashClosedPay.setFundId(fundId);
        }
        return cashClosedPayMapper.insertCashClosedPay(cashClosedPay);
    }

/**
* @author 硠君
* @Description 现金应收应付的删除方法
* @Date 15:03 2020/9/22
* @Parm [cashClosedPayId]
* @return int
**/

    @Override
    public int deleteCashClosedPay(String cashClosedPayId) {
        if (cashClosedPayId!=null && !cashClosedPayId.equals("")){
            //得到页面传回来的cashClosedPayId，并切割成单个的集合
            String[] cashClosedPayIds=cashClosedPayId.split(",");
            int i=0;
            //遍历集合，将cashClosedPayId分别调用删除方法
            for (String cashId:cashClosedPayIds) {
                i = cashClosedPayMapper.deleteCashClosedPay(cashId);
            }
            return i;
        }else {
            return 0;
        }
    }

/**
* @author 硠君
* @Description 现金应收应付的修改方法
* @Date 15:02 2020/9/22
* @Parm [cashClosedPay]
* @return int
**/

    @Override
    public int updateCashClosedPay(CashClosedPayPojo cashClosedPay) {
        System.out.println("修改的cashClosedPay:="+cashClosedPay);
        return cashClosedPayMapper.updateCashClosedPay(cashClosedPay);
    }

/**
* @author 硠君
* @Description 现金应收应付的查询方法
* @Date 15:02 2020/9/22
* @Parm [pageSize, page, dateTime, serviceType]
* @return java.util.Map<java.lang.String,java.lang.Object>
**/

    @Override
    public Map<String,Object> selectCashClosedPay(String pageSize, String page,String dateTime,String serviceType) {
        System.out.println("进入了查询的实现类");
        //创建一个结果集用于接受存储过程的返回结果
        Map<String,Object> resultMap = new HashMap<>();
        //存储过程所需条件为p_tableName/p_condition/p_page/p_pageSize/p_count/p_cursor
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
        //创建一个变量用来接收可以存在的条件搜索
        StringBuffer sqlWhere = new StringBuffer();
        int v_serviceType=0;
        if (serviceType!=null && !serviceType.equals("")){
            //如果serviceType存在，就强转成int类型，并放到sqlWhere中
            v_serviceType=Integer.parseInt(serviceType);
            sqlWhere.append(" and serviceType = "+v_serviceType);
        }
        if (dateTime!=null && !dateTime.equals("")){
            sqlWhere.append(" and dateTime = '"+dateTime+"'");
        }
//创建一个结果集用于接收数据库存储过程所需条件
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","cashClosedPay c join fund f on f.fundId=c.fundId join account a on a.accountId=c.accountId");
        map.put("p_condition",sqlWhere.toString());
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);
        cashClosedPayMapper.selectCashClosedPay(map);
        System.out.println(map.get("p_cursor"));
        //接收返回数据
        List<CashClosedPayPojo> cashClosedPays = (List<CashClosedPayPojo>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("cashClosedPays",cashClosedPays);
        resultMap.put("count",count);
        return resultMap;
    }

/**
* @author 硠君
* @Description 现金应收应付的多条件查询方法，得到相应的CashClosedPayId
* @Date 15:01 2020/9/22
* @Parm [map]
* @return java.lang.String
**/
    @Override
    public String selectCashClosedPayId(Map map) {
        return cashClosedPayMapper.selectCashClosedPayId(map);
    }

    //wufeiyun
    @Override
    public int deleteNew(CashClosedPayPojo cashClosedPay) {
        return cashClosedPayMapper.deleteNew(cashClosedPay);
    }

}
