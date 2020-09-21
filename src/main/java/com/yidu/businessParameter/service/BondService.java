package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.Bond;
import org.springframework.stereotype.Service;


import java.util.Map;

/**
 * 债券信息表服务类
 * @author 唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
@Service
public interface BondService {
    //查询
    Map<String,Object>selectBond(String pageSize, String page,String securitiesId,String drawStartDate);
    //增加
    int insertBond(Bond bond);
    //删除
    int  deleteBond(String securitiesId);
    //修改
    int updateBond(Bond bond);
}
