package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.BrokersMapper;
import com.yidu.businessParameter.pojo.Brokers;
import com.yidu.businessParameter.service.BrokersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @name 戴言露
 * @data 2020/9/2 pm
 *券商信息表实现类
 */

@Service
public class BrokersServiceImpl implements BrokersService {
    @Autowired
    BrokersMapper brokersMapper;

    /**
     * 增加
     * @param brokers
     * @return
     */
    @Override
    public boolean insert(Brokers brokers) {
        boolean flag=false;
        try {
            brokersMapper.insert(brokers);
            flag = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public boolean delete(String id){
        return brokersMapper.delete(id);
    }


    /**
     * 修改
     * @param brokers
     * @return
     */
    @Override
    public boolean update(Brokers brokers){
        return brokersMapper.update(brokers);
    }


    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Brokers> select(){
        return brokersMapper.select();
    }
}
