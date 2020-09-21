package com.yidu.reportManage.service.impl;

import com.yidu.reportManage.mapper.UnitNetWorthMapper;
import com.yidu.reportManage.service.UnitNetWorthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName UnitNetWorthServiceImpl
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:26 2020/9/20
 * @Version 1.0
 **/
@Service
public class UnitNetWorthServiceImpl implements UnitNetWorthService {
    @Resource
    UnitNetWorthMapper unitNetWorthMapper;
    @Override
    public List lineChart(String month) {
        return unitNetWorthMapper.lineChart(month);
    }
}
