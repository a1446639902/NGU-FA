package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.TransactionDataMapper;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *交易数据表
 * @Type:服务层的实现类
 * @author Tmac
 * @time 2020/9/1  14:55
 * @version   1.0
 **/
@Service
public class TransactionDataImpl implements TransactionDataService {
    @Resource
    TransactionDataMapper transactionDataMapper;

    /**
     * 查询交易数据的方法
     * @param page 页码
     * @param limit 每页显示的条数
     * @param dateTime 交易时间
     * @param securitiesName 证券名称
     * @return
     */
    @Override
    public HashMap selectTransactionData(int page,int limit,String dateTime,String securitiesName) {
        //创建一个StringBuffer来进行节省空间 append进行追加
        StringBuffer sqlWhere=new StringBuffer();
        //条件查询的拼接条件 " AND dateTime LIKE  '%"+dateTime+"%'"
        if(dateTime!=null && !dateTime.equals("")){
            sqlWhere.append(" AND dateTime LIKE  '%"+dateTime+"%'" );
        }
        if(securitiesName!=null && !securitiesName.equals("")){
            sqlWhere.append(" AND securitiesName LIKE  '%"+securitiesName+"%'" );
        }
        //创建一个HashMap
        HashMap tranMap = new HashMap();
        //定义多表查询语句
        String transactionData=" (select * from transactionData tr left join securities se on tr.securitiesId=se.securitiesId left join account ac on tr.accountId=ac.accountId left join seate se on tr.seateId=se.seateId left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
        //调用存储过程，p_tableName表名
        tranMap.put("p_tableName", transactionData);
        //p_condition查询的条件
        tranMap.put("p_condition",sqlWhere.toString());
        //p_pageSize页码
        tranMap.put("p_pageSize",limit);
        //p_page页码
        tranMap.put("p_page",page);
        //p_count总条数 0
        tranMap.put("p_count",0);
        //p_cursor游标 null
        tranMap.put("p_cursor",null);
        transactionDataMapper.selectTransactionData(tranMap);
        return tranMap;
    }

    @Override
    public int insertTransactionData(TransactionData transactionData) {
        return transactionDataMapper.insertTransactionData(transactionData);
    }

    @Override
    public int deleteTransactionData(String transactionDataId) {
        return transactionDataMapper.deleteTransactionData(transactionDataId);
    }

    /**
     * 批量删除
     * @param transactionDataId
     * @return
     */
    @Override
    public int deleteTransactionDataTwo(String transactionDataId) {
        //通过transactionDataId.split进行切割返回一个数组
        String[] split = transactionDataId.split(",");
        //创建一个集合
        List<String> transactionDataList = new ArrayList<>();
        //遍历切割id
        for (String id : split) {
            //把切割后的id放入到集合
            transactionDataList.add(id);
        }
        return transactionDataMapper.deleteTransactionDataTwo(transactionDataList);
    }


    @Override
    public int updateTransactionData(TransactionData transactionData) {
        return transactionDataMapper.updateTransactionData(transactionData);
    }





}
