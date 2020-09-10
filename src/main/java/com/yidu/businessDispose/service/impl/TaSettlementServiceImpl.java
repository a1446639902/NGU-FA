package com.yidu.businessDispose.service.impl;

import com.yidu.businessDispose.mapper.TaSettlementMapper;
import com.yidu.businessDispose.pojo.TaSettlement;
import com.yidu.businessDispose.service.TaSettlementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TA交易结算信息表的实现类
 *
 * @author 唐赈环
 * @version 版本1.0
 * @date 2020/09/09 16 点32分
 */
@Service
@Transactional
public class TaSettlementServiceImpl implements TaSettlementService {
    @Resource
    TaSettlementMapper taSettlementMapper;

    @Override
    public Map<String, Object> selectTaSettlement(String pageSize, String page, String dateTime, String transactionType, String status) {
        //创建一个结果集Map用于存放两个结果变量
        Map<String, Object> resultMap = new HashMap<>();
        //定义一个分页条数变量
        int v_pageSize = 0;
        //判断传入的pageSize是否为null/空
        if (pageSize != null && !pageSize.equals("")) {
            //通过Integer包装类将String类型转换成int基础数据类型
            v_pageSize = Integer.parseInt(pageSize);
        }
        //定义一个分页页码变量
        int v_page = 0;
        //判断传入的page是否为null/空
        if (page != null && !page.equals("")) {
            //通过Integer包装类将String类型转换成int基础数据类型
            v_page = Integer.parseInt(page);
        }
        StringBuffer sqlWhere = new StringBuffer();
        if (dateTime != null && !dateTime.equals("")) {
            sqlWhere.append(" AND dateTime LIKE  '%" + dateTime + "%'");
        }

        if (transactionType != null && !transactionType.equals("")) {
            sqlWhere.append(" AND transactionType LIKE  '%" + transactionType + "%'");
        }
        if (status != null && !status.equals("")) {
            int i = Integer.parseInt(status);
            sqlWhere.append(" AND transactionStatus =" + i);
        }
        System.out.println("==========" + sqlWhere.toString());

        //创建一个Map，用于存储过程的调用传值
        Map<String, Object> map = new HashMap<>();
        //传入存储过程需要查询的表名
        map.put("p_tableName", "taTransaction");
        //传入查询条件
        map.put("p_condition", sqlWhere.toString());
        //传入分页显示条数
        map.put("p_pageSize", v_pageSize);
        //传入分页页码
        map.put("p_page", v_page);
        //创建out参数，返回数据总条数
        map.put("p_count", 0);
        //创建out游标变量，返回查询数据
        map.put("p_cursor", null);
        //调用Mapper执行查询
        taSettlementMapper.selectTaSettlement(map);
        //接收返回数据
        List<TaSettlement> TaSettlementList = (List<TaSettlement>) map.get("p_cursor");
        //接收返回总条数
        int v_count = (int) map.get("p_count");
        //将结果放入结果集Map
        resultMap.put("taSettlementList", TaSettlementList);
        resultMap.put("count", v_count);
        return resultMap;
    }

    @Override
    public int insertTaSettlement(TaSettlement taSettlement) {
        int i = taSettlementMapper.insertTaSettlement(taSettlement);
        return i;
    }

    @Override
    public int deleteTaSettlement(String dateTime) {
        String[] split = dateTime.split(",");
        ArrayList<Object> arrayList = new ArrayList<>();
        for (String id : split) {
            arrayList.add(id);
        }
        return taSettlementMapper.deleteTaSettlement(arrayList);
    }

    @Override
    public int updateTaSettlement(String taTransactionIds, String status) {
        ArrayList<Object> taTransactionIdList = new ArrayList<>();
        String[] split = taTransactionIds.split(",");
        for (String taTransactionId : split) {
            taTransactionIdList.add(taTransactionId);
        }
        if (status.equals("0")) {
            return taSettlementMapper.updateTaSettlement(taTransactionIdList);
        } else {
            return taSettlementMapper.updateTaSettlementTwo(taTransactionIdList);
        }
    }

}
