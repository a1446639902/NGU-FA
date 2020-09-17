package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.EquityDataMapper;
import com.yidu.businessData.pojo.EquityData;
import com.yidu.businessData.service.EquityDataService;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置Service实现类
 */

@Service
public class EquityDataServiceImpl implements EquityDataService {
    @Resource
    EquityDataMapper equityDataMapper;
    @Override
    public int insertEquityData(EquityData equityData) {
        return equityDataMapper.insertEquityData(equityData);
    }

    @Override
    public int deleteEquityData(String equityDataId) {
        //将id转为数据
        String[] split = equityDataId.split(",");
        //创建存放id的集合
        ArrayList<Object> equityIdList = new ArrayList<>();
        for (String id : split) {
            //将id存入集合
            equityIdList.add(id);
        }

        return equityDataMapper.deleteEquityData(equityIdList);
    }

    @Override
    public int updateEquityData(EquityData equityData) {
        return equityDataMapper.updateEquityData(equityData);
    }

    @Override
    public Map<String, Object> selectEquityData(String pageSize, String page , String equitiesType , String equitiesExright) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断v_pageSize是否为空
        if (pageSize != null && !pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize=Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page != null && !page.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }
        int v_equitiesType=0;
        StringBuffer sqlWhere=new StringBuffer();
        if(equitiesExright !=null && !equitiesExright.equals("")) {
            sqlWhere.append("AND equitiesExright LIKE '%" + equitiesExright + "%'");
        }
            if(equitiesType!=null&&!equitiesType.equals("")) {
                v_equitiesType = Integer.parseInt(equitiesType);
                sqlWhere.append("AND equitiesType LIKE '%" + v_equitiesType + "%'");
            }
        String p_tableName = "(select * from " + SysTableNameListUtil.ED +" e " +
                "join (select securitiesName,securitiesId from "+SysTableNameListUtil.SE+" ) s " +
                "on e.SECURITYID=s.securitiesId)";

        //创建一个Map，用于存储过程的调用传值
        Map<String,Object> map = new HashMap<>();
        //传入存储过程需要的查询的表名
        map.put("p_tableName",p_tableName);
        //传入查询条件
        map.put("p_condition",sqlWhere.toString());
        //传入分页显示条数
        map.put("p_pageSize",v_pageSize);
        //传入分页页码
        map.put("p_page",v_page);
        //创建out参数，返回数据总条数
        map.put("p_count",0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor",null);
        //调用Mapper执行查询
        equityDataMapper.selectEquityData(map);
        //接收返回数据
        List<EquityData> equityDataList = (List<EquityData>) map.get("p_cursor");
        //接收返回总条数
        int v_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("equityDataList",equityDataList);
        resultMap.put("count",v_count);
        System.out.println(resultMap.get("equityDataList"));
        //返回结果集Map
        return resultMap;
    }
}
