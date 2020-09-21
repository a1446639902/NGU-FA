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
    public Map<String,Object>  selectTable(String pageSize, String page,String select,String dateTime) {
        System.out.println("select:="+select+"//////dateTime:="+dateTime);
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
//      页面载入阶段未选择值，设置默认当前时间
        //判断是否有时间传回，若无，则默认当前时间
        if (dateTime==null || dateTime.equals("")){
            //SimpleDateFormat设定日期格式为yyyy-MM-dd
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //得到当前时间
            Date today=new Date();
            //将当前时间格式化
            dateTime = sdf.format(today);
        }
        //创建StringBuffer用于接收sql条件
        StringBuffer sqlWhere =new StringBuffer();
        //根据页面传回的select值，判断按什么搜搜
        if (select==null || select.equals("")){
            select="1";
        }
        if (Integer.parseInt(select)==1){
            //select=1按日期搜索，SETTLEMENTDATE=dateTime
            sqlWhere.append(" SETTLEMENTDATE = '"+dateTime);
        }else if (Integer.parseInt(select)==2){
            //select=2按月份搜索，SETTLEMENTDATE=yyyy-MM,将dateTime转成相应格式后
            String strTime = dateTime.substring(0, 7);
            //对月份进行模糊查询
            sqlWhere.append(" SETTLEMENTDATE like '"+strTime+"%");
        }
        System.out.println("====select:"+select+"========dateTime:"+dateTime);
        Map<String,Object> map = new HashMap<>();
        map.put("p_tableName","(select (case when EXCHANGE=1 then '上海' else '深圳' end)||(case when SECURITIESTYPE=1 then '债券' else '股票' end) as name," +
                "sum(netreceipts*flag) as netreceipts,sum(transfer) as transfer,sum(brokerage) as brokerage,sum(stamp) as stamp," +
                "sum(management) as management,sum(COMMISSION) as commission,sum(TOTALSUM*flag) as totalsum from (select * from TRANSACTIONDATA t " +
                "join (select * from SECURITIES) s on t.SECURITIESID=s.SECURITIESID) where "+sqlWhere+"' group by EXCHANGE,SECURITIESTYPE)");
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
