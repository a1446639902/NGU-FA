package com.yidu.cashControl.service.impl;

import com.yidu.cashControl.mapper.TransferMoneyMapper;
import com.yidu.cashControl.pojo.TransferMoneyPojo;
import com.yidu.cashControl.service.TransferMoneyService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author 黄志豪
 * @version 1.0
 * @Type
 * @time 2020/9/10
 **/
@Service
public class TransferMoneyServiceImpl implements TransferMoneyService {
    @Resource
    TransferMoneyMapper transferMoneyMapper;
    @Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectTransferMoney(int page, int limit) {
        HashMap<Object, Object> transferMoneyMap = new HashMap<>();
        transferMoneyMap.put("p_tableName", SysTableNameListUtil.TM);
        transferMoneyMap.put("p_condition","");
        transferMoneyMap.put("p_pageSize",limit);
        transferMoneyMap.put("p_page",page);
        transferMoneyMap.put("p_count",0);
        transferMoneyMap.put("p_cursor",null);
        transferMoneyMapper.selectTransferMoney(transferMoneyMap);
        System.out.println(transferMoneyMap.get("p_cursor"));
        return transferMoneyMap;

    }

    @Override
    public int insertTransferMoney(TransferMoneyPojo transferMoneyPojo) {
        transferMoneyPojo.setTransferMoneyId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.TM));
        transferMoneyPojo.setFoundId("289289289");
        return transferMoneyMapper.insertTransferMoney(transferMoneyPojo);
    }

    @Override
    public int updateTransferMoney(TransferMoneyPojo transferMoneyPojo) {
        return transferMoneyMapper.updateTransferMoney(transferMoneyPojo);
    }
    @Override
    public int deleteTransferMoney(String transferMoneyId) {
        return transferMoneyMapper.deleteTransferMoney(transferMoneyId);
    }
}
