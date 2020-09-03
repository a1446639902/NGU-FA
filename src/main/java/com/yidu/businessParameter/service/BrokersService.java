package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.Brokers;
import org.springframework.stereotype.Service;

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
    boolean insert(Brokers brokers);


    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(String id);


    /**
     * 修改
     * @param brokers
     * @return
     */
    boolean update(Brokers brokers);


    /**
     * 查询所有
     * @return
     */
    List<Brokers> select();
}
