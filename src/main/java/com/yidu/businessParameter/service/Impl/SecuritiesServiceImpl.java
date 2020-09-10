package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.SecuritiesMapper;
import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.service.SecuritiesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author xbf
 *date 2020-9-3
 * 证券信息biz实现类
 * @vesion 1.1
 **/
@Service
@Transactional
public class SecuritiesServiceImpl implements SecuritiesService {
    @Resource
    SecuritiesMapper securitiesMapper;
    @Override
    public int insertSecurities(SecuritiesPojo securitiesPojo) {
        return securitiesMapper.insertSecurities(securitiesPojo);
    }

    @Override
    public int deleteSecurities(String securitiesId) {
        //定义一个数组接收编号，切割字符串
        String[] split = securitiesId.split(",");
        //定义一个整型集合
        List<String> securitiesList = new ArrayList<String>();
        //循环数组
        for (String id : split) {
            //将数组循环的值添加到集合中，强转为整型
            securitiesList.add(id);
        }
        return securitiesMapper.deleteSecurities(securitiesList);
    }

    @Override
    public int updateSecurities(SecuritiesPojo securitiesPojo) {
        return securitiesMapper.updateSecurities(securitiesPojo);
    }

    @Override
    public HashMap selectSecurities() {
        HashMap securitiesMap = new HashMap();
        String tableName="(select * from securities join stock on securities.stockId=stock.stockId)";
        securitiesMap.put("p_tableName",tableName);
        securitiesMap.put("p_condition","");
        securitiesMap.put("p_pageSize",10);
        securitiesMap.put("p_page",1);
        securitiesMap.put("p_count",0);
        securitiesMap.put("p_cursor",null);
        securitiesMapper.selectSecurities(securitiesMap);
        return securitiesMap;
    }
}
