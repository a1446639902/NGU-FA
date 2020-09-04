package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.BondPojo;

import java.util.List;
import java.util.Map;

/**
 * 债券信息表数据库访问接口
 * @author  唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
public interface BondMapper {
    //增加
    int insertBond(BondPojo bondPojo);
    //删除
    void deleteBond(int securitiesId);
    //修改
    int updateBond(BondPojo bondPojo);
    //查所有
    static void selectBond(Map map);
}
