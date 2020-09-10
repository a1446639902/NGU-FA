package com.yidu.dayDispose.service.impl;

import com.yidu.businessData.pojo.CashClosedPayPojo;
import com.yidu.dayDispose.mapper.IncomePaymentMapper;
import com.yidu.dayDispose.pojo.IncomePaymentPojo;
import com.yidu.dayDispose.service.IncomePaymentService;
import com.yidu.util.DateTimeUtil;
import com.yidu.util.DbUtil;
import com.yidu.util.GetFundIdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 收益支付实现类
 * @ClassName IncomePaymentServiceImpl
 * @Description: TODO
 * @Author 硠君
 * @Date create in 8:54 2020/9/9
 * @Version 1.0
 **/
@Service
@Transactional
public class IncomePaymentServiceImpl implements IncomePaymentService {
    @Resource
    IncomePaymentMapper incomePaymentMapper;

    @Override
    public Map<String,Object> selectCashClosedPays(String pageSize, String page, String businessDate,HttpServletRequest request) {
        System.out.println("进入了查询的现金应收应付实现类");
    //创建一个结果集用于接受存储过程的返回结果
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
        //得到请求中的session中的fundId
        String fundId = GetFundIdUtil.getFundId(request);
        StringBuffer sqlWhere = new StringBuffer();
        // and c.fundId='"+fundId+"'
        //sqlWhere.append("and c.businessType=3");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        if (businessDate!=null && !businessDate.equals("")){
            try {
                long dif = df.parse(businessDate).getTime()-86400*1000;//求得毫秒数 减一天
                date.setTime(dif);
                System.out.println("减少一天之后:=" + df.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sqlWhere.append(" and c.businessDate = '"+df.format(date)+"'");
        }
//创建一个结果集用于接收数据库存储过程所需条件——为p_tableName/p_condition/p_page/p_pageSize/p_count/p_cursor
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","(select * from cashClosedPayInventory c join account a on a.accountId=c.accountId where c.businessType=3)");
        map.put("p_condition",sqlWhere.toString());
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);
        //调用Mapper执行查询
        incomePaymentMapper.selectCashClosedPays(map);
        System.out.println(map.get("p_cursor"));
        //接收返回数据
        List<IncomePaymentPojo> IncomePayments = (List<IncomePaymentPojo>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("IncomePayments",IncomePayments);
        resultMap.put("count",count);
        return resultMap;
    }
    @Override
    public Map<String,Object>selectSecuritiesClosedPay(String pageSize, String page,String businessDate,HttpServletRequest request) {
        System.out.println("进入了查询的证券应收应付实现类");
//创建一个结果集用于接受存储过程的返回结果
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
        //得到请求中的session中的fundId
        String fundId = GetFundIdUtil.getFundId(request);
        StringBuffer sqlWhere = new StringBuffer();
        //and sci.fundId='"+fundId+"'
        //sqlWhere.append(" and sci.securitiesType=3 ");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        if (businessDate!=null && !businessDate.equals("")){
            try {
                long dif = df.parse(businessDate).getTime()-86400*1000;//求得毫秒数 减一天
                date.setTime(dif);
                System.out.println("减少一天之后:=" + df.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sqlWhere.append(" and dateTime = '"+df.format(date)+"'");
        }
//创建一个结果集用于接收数据库存储过程所需条件——为p_tableName/p_condition/p_page/p_pageSize/p_count/p_cursor
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","(select * from securitiesClosedPayInventory sci join account a on sci.accountId=a.accountId join securities s on sci.securitiesId=s.securitiesId where sci.securitiesType=3)");
        map.put("p_condition",sqlWhere.toString());
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);
        //调用Mapper执行查询
        incomePaymentMapper.selectSecuritiesClosedPay(map);
        System.out.println(map.get("p_cursor"));
        //接收返回数据
        List<IncomePaymentPojo> IncomePayments = (List<IncomePaymentPojo>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("IncomePayments",IncomePayments);
        resultMap.put("count",count);
        return resultMap;
    }

    @Override
    public Map<String,Object>selectTwoCost(String pageSize, String page,String businessDate,HttpServletRequest request) {
        System.out.println("进入了查询的两费实现类");
//创建一个结果集用于接受存储过程的返回结果
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
        //得到请求中的session中的fundId
        String fundId = GetFundIdUtil.getFundId(request);
        StringBuffer sqlWhere = new StringBuffer();
        //and c.fundId='"+fundId+"'
        //sqlWhere.append(" and c.businessType=1 and c.businessType=2 ");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        if (businessDate!=null && !businessDate.equals("")){
            try {
                long dif = df.parse(businessDate).getTime()-86400*1000;//求得毫秒数 减一天
                date.setTime(dif);
                System.out.println("减少一天之后:=" + df.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            sqlWhere.append(" and c.businessDate = '"+df.format(date)+"'");
        }
//创建一个结果集用于接收数据库存储过程所需条件——为p_tableName/p_condition/p_page/p_pageSize/p_count/p_cursor
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","(select * from cashClosedPayInventory c join account a on c.accountId=a.accountId where c.businessType=1 and c.businessType=2)");
        map.put("p_condition",sqlWhere.toString());
        map.put("p_pageSize",v_pageSize);
        map.put("p_page",v_page);
        map.put("p_count",0);
        map.put("p_cursor",null);
        //调用Mapper执行查询
        incomePaymentMapper.selectTwoCost(map);
        System.out.println(map.get("p_cursor"));
        //接收返回数据
        List<IncomePaymentPojo> IncomePayments = (List<IncomePaymentPojo>) map.get("p_cursor");
        //接收返回总条数
        int count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("IncomePayments",IncomePayments);
        resultMap.put("count",count);
        return resultMap;
    }
    /*revenueProvisionMap.put("p_tableName","(select round(ca.cashBlance* (a.cardRate/100/(case when a.procisionDays = 1 then 360\n" +
                "    when a.procisionDays=2 then 365 else 366 end )  ),2) as interest,a.cardRate,\n" +
                "    a.blankName,a.accountName,ca.cashBlance,a.deposit,(case when a.deposit = 1 then '活期'\n" +
                "     else  '定期' end) as depositName,ca.dateTime,(case when a.procisionDays = 1 then 360\n" +
                "    when a.procisionDays=2 then 365 else 366 end )as procisionDayName\n" +
                "from (select * from cashInventory where dateTime='2020-09-08')\n" +
                "    ca join account a on ca.accountId=a.accountId)");*/
}
