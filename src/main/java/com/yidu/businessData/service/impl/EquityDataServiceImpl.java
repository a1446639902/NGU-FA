package com.yidu.businessData.service.impl;

import com.yidu.businessData.mapper.EquityDataMapper;
import com.yidu.businessData.pojo.EquityData;
import com.yidu.businessData.service.EquityDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 *@author wzh
 *date 2020-9-2
 * 权益数据设置Service实现类
 */

@Service
public class EquityDataServiceImpl implements EquityDataService {
    @Resource
    private EquityDataMapper equityDataMapper;
    @Override
    public List<EquityData> selectEquityDataMapper() {
        return equityDataMapper.selectEquityDataMapper();
    }
}
