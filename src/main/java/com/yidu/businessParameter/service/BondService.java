package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.BondPojo;

import java.util.List;
import java.util.Map;

/**
 * 债券信息表服务类
 * @author 唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
public interface BondService {
    //增加
    public int insertBond(BondPojo bondPojo);
    //删除
    public void deleteBond(int securitiesId);
    //修改
    public int updateBond(BondPojo bondPojo);
    //查
    public Map<String,Object> selectBond(String pageSize, String page);

}
