package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * author xbf
 *date 2020-9-3
 * 证券信息biz
 * @vesion 1.0
 **/
@Service
public interface SecuritiesService {
    public int insertSecurities(SecuritiesPojo securitiesPojo);
    public void deleteSecurities(String securitiesId);
    public int updateSecurities(SecuritiesPojo securitiesPojo);
    public HashMap selectSecurities();
    /*public List<SecuritiesPojo> selectSecurities();*/
}
