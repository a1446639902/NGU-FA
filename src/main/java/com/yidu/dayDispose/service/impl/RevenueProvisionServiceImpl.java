package com.yidu.dayDispose.service.impl;

import com.yidu.dayDispose.mapper.RevenueProvisionMapper;
import com.yidu.dayDispose.service.RevenueProvisionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
@Service
public class RevenueProvisionServiceImpl implements RevenueProvisionService {
    @Resource
    RevenueProvisionMapper revenueProvisionMapper;
    @Override
    public HashMap selectRevenueProvision(int page, int limit) {
        HashMap revenueProvisionMap = new HashMap();
        revenueProvisionMap.put("p_tableName","(select * from account a  join cashInventory c on a.accountId=c.accountId)");
        revenueProvisionMap.put("p_condition","");
        revenueProvisionMap.put("p_pageSize",limit);
        revenueProvisionMap.put("p_page",page);
        revenueProvisionMap.put("p_count",0);
        revenueProvisionMap.put("p_cursor",null);
        revenueProvisionMapper.selectRevenueProvision(revenueProvisionMap);
            return revenueProvisionMap;
        }
    }

