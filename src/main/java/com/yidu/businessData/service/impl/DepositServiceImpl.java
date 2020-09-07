package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.DepositMapper;
import com.yidu.businessData.pojo.DepositPojo;
import com.yidu.businessData.service.DepositService;
import com.yidu.util.DbUtil;
import com.yidu.util.SysTableNameListUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * 存款业务表
 * @Type 服务层的实现类
 * @author 黄志豪
 * @version 1.0
 * @time 2020/9/7
 **/
//@Service
public class DepositServiceImpl implements DepositService {
    //@Resource
    DepositMapper depositMapper;
    //@Resource
    DbUtil dbUtil;
    @Override
    public HashMap selectDeposit(int page,int limit) {
        HashMap depositMap = new HashMap<>();
        depositMap.put("p_tableName", SysTableNameListUtil.DE);
        depositMap.put("p_condition","");
        depositMap.put("p_pageSize",limit);
        depositMap.put("p_page",page);
        depositMap.put("p_count",0);
        depositMap.put("p_cursor",null);
        depositMapper.selectDeposit(depositMap);
        return depositMap;
    }

    @Override
    public int insertDeposit(DepositPojo depositPojo) {
        depositPojo.setDepositId(dbUtil.requestDbTableMaxId(SysTableNameListUtil.DE));
        return depositMapper.insertDeposit(depositPojo);
    }

    @Override
    public int updateDeposit(DepositPojo depositPojo) {
        return depositMapper.updateDeposit(depositPojo);
    }

    @Override
    public int deleteDeposit(int depositId) {
        return depositMapper.deleteDeposit(depositId);
    }
}
