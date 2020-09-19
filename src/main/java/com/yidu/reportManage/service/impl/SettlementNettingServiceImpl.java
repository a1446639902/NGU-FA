package com.yidu.reportManage.service.impl;

import com.yidu.reportManage.mapper.SettlementNettingMapper;
import com.yidu.reportManage.service.SettlementNettingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
    public Map selectTable(Map map) {
        return settlementNettingMapper.selectTable(map);
    }
}
