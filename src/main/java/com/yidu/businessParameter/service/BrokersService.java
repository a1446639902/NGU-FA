package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.Brokers;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @name 戴言露
 * @data 2020/9/2 pm
 *券商信息表服务层
 */

@Service
public interface BrokersService {
    /**
     * 增加
     * @param brokers
     * @return
     */
    int insert(Brokers brokers);


    /**
     * 删除
     * @param brokersId
     * @return
     */
    int brokersDelete(String brokersId);


    /**
     * 修改
     * @param brokers
     * @return
     */
    int update(Brokers brokers);


    /**
     * 查询
     * @return
     */
    public HashMap brokersSelect(int page, int limit, String selectBrokersName);
}
