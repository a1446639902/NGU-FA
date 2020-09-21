package com.yidu.businessDispose.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Service
public interface EquityDisposeService {
    /**
     * 权益处理查询方法
     * @param pageSize
     * @param page
     * @param equitiesType
     * @param equitiesExright
     * @param disposeStatus
     * @return
     */
    public Map<String,Object> selectEquityDispose(String pageSize, String page, String equitiesType, String equitiesExright,String disposeStatus);

    /**
     * 权益处理修改方法
     * @param equityDisPose
     * @param request
     * @return
     */
    public int updateEquityDispose(String equityDisPose,HttpServletRequest request);

    /**
     * 权益处理修改方法
     * @param equityDataId
     * @return
     */
    public int updateEquityDisposeTwo(String equityDataId);
}
