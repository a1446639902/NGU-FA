package com.yidu.reportManage.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName UnitNetWorthService
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:25 2020/9/20
 * @Version 1.0
 **/
@Service
public interface UnitNetWorthService {
    List<Double> lineChart(String month);
}
