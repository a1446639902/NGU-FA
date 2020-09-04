package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.BondMapper;
import com.yidu.businessParameter.pojo.BondPojo;
import com.yidu.businessParameter.service.BondService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  债券信息表的实现类
 *  @author 唐赈环
 *  @date  2020/09/01 15点32分
 *  @version 版本1.0
 */
@Service
public class BondServiceImpl implements BondService {
    @Resource
    BondMapper bondMapper;

    @Override
    public int insertBond(BondPojo bondPojo) {
        int i = bondMapper.insertBond(bondPojo);
        return i;
    }

    @Override
    public void deleteBond(int securitiesId) {
        bondMapper.deleteBond(securitiesId);
    }

    @Override
    public int updateBond(BondPojo bondPojo) {
        int a= bondMapper.updateBond(bondPojo);
        return a;
    }

    @Override
    public Map<String, Object> selectBond(String pageSize, String page) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String , Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断传入的pageSize是否为null/空
        if (pageSize!=null&&!pageSize.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize=Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page!=null&&!page.equals("")){
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page=Integer.parseInt(page);
        }
        //创建一个Map，用于存储过程的调用传值
        Map<String,Object> map = new HashMap<>();
        //传入存储过程需要查询的表名
        map.put("p_tableName","taTransaction");
        //传入查询条件
        map.put("p_condition","");
        //传入分页显示条数
        map.put("p_pageSize",v_pageSize);
        //传入分页页码
        map.put("p_page",v_page);
        //创建out参数，返回数据总条数
        map.put("p_count",0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor",null);
        //调用Mapper执行查询
        bondMapper.selectBond(map);
        //接收返回数据
        List<BondPojo> bondPojoList = (List<BondPojo>) map.get("p_cursor");
        //接收返回总条数
        int v_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("bondPojoList",bondPojoList);
        resultMap.put("count",v_count);
        //返回结果集Map
        System.out.println(v_count);
        System.out.println(bondPojoList);
        return resultMap;
    }
}
