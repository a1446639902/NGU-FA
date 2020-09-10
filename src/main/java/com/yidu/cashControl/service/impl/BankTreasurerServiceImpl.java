package com.yidu.cashControl.service.impl;

import com.yidu.cashControl.mapper.BankTreasurerMapper;
import com.yidu.cashControl.pojo.BankTreasurerPojo;
import com.yidu.cashControl.service.BankTreasurerService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 资金调拨表
 * @Type 服务层的实现类
 * @author 黄志豪
 * @version 1.1
 * @time 2020/9/7
 **/
@Transactional
@Service
public class BankTreasurerServiceImpl implements BankTreasurerService {
    @Resource
    BankTreasurerMapper bankTreasurerMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectBankTreasurer(int page, int limit,String dbTime,String allocatingType,String flag) {
        String p_tableName=" (select * from bankTreasurer bt join  account a on bt.accountId = a.accountId) ";
        StringBuffer stringBuffer = new StringBuffer();
        if(dbTime!=null && !dbTime.equals("")){
            stringBuffer.append(" and dbTime='"+dbTime+"'");
        }
        if (allocatingType!=null && !allocatingType.equals("")){
            stringBuffer.append(" and allocatingType="+allocatingType);
        }
        if(flag!=null && !flag.equals("")){
            int i = Integer.parseInt(flag);
            stringBuffer.append((" and flag=")+i);
        }
        System.out.println(stringBuffer.toString());
        HashMap bankTreasurerMap = new HashMap();
        bankTreasurerMap.put("p_tableName", p_tableName);
        bankTreasurerMap.put("p_condition",stringBuffer.toString());
        bankTreasurerMap.put("p_pageSize",limit);
        bankTreasurerMap.put("p_page",page);
        bankTreasurerMap.put("p_count",0);
        bankTreasurerMap.put("p_cursor",null);
        bankTreasurerMapper.selectBankTreasurer(bankTreasurerMap);
        return bankTreasurerMap;
    }

    @Override
    public int insertBankTreasurer(BankTreasurerPojo bankTreasurerPojo) {
        bankTreasurerPojo.setBankTreasurerId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.BT));
        bankTreasurerPojo.setFundId("289289289");
        bankTreasurerPojo.setDateTime("2020-09-07");
        return bankTreasurerMapper.insertBankTreasurer(bankTreasurerPojo);
    }

    @Override
    public int updateBankTreasurer(BankTreasurerPojo bankTreasurerPojo) {
        return bankTreasurerMapper.updateBankTreasurer(bankTreasurerPojo);
    }

    @Override
    public int deleteBankTreasurer(String bankTreasurerIds) {
        ArrayList bankTreasurerList = new ArrayList<>();
        String[] arrBankTreasurerId = bankTreasurerIds.split(",");
        for (String bankTreasurerId : arrBankTreasurerId) {
            bankTreasurerList.add(bankTreasurerId);
            System.out.println(bankTreasurerId);
        }

        return bankTreasurerMapper.deleteBankTreasurer(bankTreasurerList);

    }
}
