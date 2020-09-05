package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.SecuritiesMapper;
import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.service.SecuritiesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * author xbf
 *date 2020-9-3
 * 证券信息biz实现类
 * @vesion 1.1
 **/
@Service
public class SecuritiesServiceImpl implements SecuritiesService {
    @Resource
    SecuritiesMapper securitiesMapper;
    @Override
    public int insertSecurities(SecuritiesPojo securitiesPojo) {
        return securitiesMapper.insertSecurities(securitiesPojo);
    }

    @Override
    public int deleteSecurities(String securitiesId) {
        return securitiesMapper.deleteSecurities(securitiesId);
    }

    @Override
    public int updateSecurities(SecuritiesPojo securitiesPojo) {
        return securitiesMapper.updateSecurities(securitiesPojo);
    }

    @Override
    public HashMap selectSecurities() {
        HashMap securitiesMap = new HashMap();
        securitiesMap.put("p_tableName","securities");
        securitiesMap.put("p_condition","");
        securitiesMap.put("p_pageSize",10);
        securitiesMap.put("p_page",1);
        securitiesMap.put("p_count",0);
        securitiesMap.put("p_cursor",null);
        securitiesMapper.selectSecurities(securitiesMap);
        return securitiesMap;
    }
}
