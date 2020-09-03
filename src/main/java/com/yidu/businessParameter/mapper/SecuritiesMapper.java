package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 用户的dao方法
 * date:2020.9.3
 * @author xbf
 * @version 1.0
 */
@Mapper
public interface SecuritiesMapper {
    public int insertSecurities(SecuritiesPojo securitiesPojo);
    public void deleteSecurities(String securitiesId);
    public int updateSecurities(SecuritiesPojo securitiesPojo);
    public void selectSecurities(HashMap hashMap);
}
