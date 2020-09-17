package com.yidu.businessDispose.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface EquityDisposeService {
    public Map<String,Object> selectEquityDispose(String pageSize, String page, String equitiesType, String equitiesExright,String disposeStatus);
    public int updateEquityDispose(String equityDisPose);
    public int updateEquityDisposeTwo(String equityDataId);
}
