package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.TransactionDataMapper;
import com.yidu.businessData.pojo.Import.TransactionImport;
import com.yidu.businessData.pojo.TransactionData;
import com.yidu.businessData.service.TransactionDataService;
import com.yidu.util.ExcelReadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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


    @Value("${location}")
    private String location;

    @Override
    public HashMap selectTransactionData(int page,int limit,String dateTime,String securitiesName) {

        StringBuffer sqlWhere=new StringBuffer();
        if(dateTime!=null && !dateTime.equals("")){
            sqlWhere.append(" AND dateTime LIKE  '%"+dateTime+"%'" );
        }
        if(securitiesName!=null && !securitiesName.equals("")){
            sqlWhere.append(" AND securitiesName LIKE  '%"+securitiesName+"%'" );
        }


        HashMap tranMap = new HashMap();
        String transactionData=" (select * from transactionData tr left join securities se on tr.securitiesId=se.securitiesId left join account ac on tr.accountId=ac.accountId left join seate se on tr.seateId=se.seateId left join brokers br on tr.brokersId=br.brokersId left join fund f on tr.fundId = f.fundId) ";
        tranMap.put("p_tableName", transactionData);
        tranMap.put("p_condition",sqlWhere.toString());
        tranMap.put("p_pageSize",limit);
        tranMap.put("p_page",page);
        tranMap.put("p_count",0);
        tranMap.put("p_cursor",null);
        transactionDataMapper.selectTransactionData(tranMap);
        return tranMap;
    }

    @Override
    public int insertTransactionData(TransactionData transactionData) {
        System.out.println(transactionData);
        if(transactionData.getTransactionDataMode()==1)
        {
            transactionData.setFlag(-1);
        }else if(transactionData.getTransactionDataMode()==2 || transactionData.getTransactionDataMode()==3 ||transactionData.getTransactionDataMode()==4)
        {
            transactionData.setFlag(1);
        }
        return transactionDataMapper.insertTransactionData(transactionData);
    }

    @Override
    public int deleteTransactionData(String transactionDataId) {
        return transactionDataMapper.deleteTransactionData(transactionDataId);
    }

    @Override
    public int deleteTransactionDataTwo(String transactionDataId) {
        String[] split = transactionDataId.split(",");
        List<String> transactionDataList = new ArrayList<>();
        for (String id : split) {
            transactionDataList.add(id);
        }
        return transactionDataMapper.deleteTransactionDataTwo(transactionDataList);
    }


    @Override
    public int updateTransactionData(TransactionData transactionData) {
        return transactionDataMapper.updateTransactionData(transactionData);
    }

    /**
     * excel 数据导入
     * @param excelFileName
     * @return
     */
    public void importTransactionData(String excelFileName){
        try {
            InputStream inp = new FileInputStream(location + excelFileName);
            List<String[]> excelDateList = ExcelReadUtils.readLoanInfoArray(inp,15);
            excelDateList.forEach(item -> {
                TransactionImport data = ExcelReadUtils.setTransactionImport(item);
                this.insertTransactionData(data.getTransactionData());
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
