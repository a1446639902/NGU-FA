package com.yidu.reportManage.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName SettlementNettingService
 * @Description: TODO
 * @Author 硠君
 * @Date create in 17:44 2020/9/18
 * @Version 1.0
 **/
@Service
public interface SettlementNettingService {
    Map selectTable(Map map);
}
