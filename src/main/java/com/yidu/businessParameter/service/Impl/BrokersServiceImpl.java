package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.BrokersMapper;
import com.yidu.businessParameter.pojo.Brokers;
import com.yidu.businessParameter.service.BrokersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public int insert(Brokers brokers) {
        return brokersMapper.insert(brokers);
    }


    /**
     * 删除
     * @param brokersId
     * @return
     */
    @Override
    public int brokersDelete(String brokersId){
        //定义一个数组接收编号，切割字符串
        String[] split = brokersId.split(",");
        //定义一个整型集合
        List<String> brokersList = new ArrayList<String>();
        //循环数组
        for (String id : split) {
            //将数组循环的值添加到集合中，强转为整型
            brokersList.add(id);
        }

        return brokersMapper.brokersDelete(brokersList);
    }


    /**
     * 修改
     * @param brokers
     * @return
     */
    @Override
    public int update(Brokers brokers){
        return brokersMapper.update(brokers);
    }


    /**
     * 查询
     * @return
     */
    @Override
    public HashMap brokersSelect(int page, int limit, String brokersName) {
        String sql = "";
        if (brokersName != null&& !brokersName.equals("")) {
            sql = sql + " and brokersName like '%" + brokersName + "%'";
        }
        System.out.println(sql);
        HashMap brokersMap = new HashMap();
        brokersMap.put("p_tableName", "brokers");
        brokersMap.put("p_condition", sql);
        brokersMap.put("p_pageSize", limit);
        brokersMap.put("p_page", page);
        brokersMap.put("p_count", 0);
        brokersMap.put("p_cursor", null);
        brokersMapper.brokersSelect(brokersMap);
        return brokersMap;
    }
}
