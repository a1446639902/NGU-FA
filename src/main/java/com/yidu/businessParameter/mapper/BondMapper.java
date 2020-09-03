package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.BondPojo;

import java.util.List;

/**
 * 债券信息表数据库访问接口
 * @author  唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
public interface BondMapper {
    //增加
    public int insertBond(BondPojo bondPojo);
    //删除
    public int deleteBond(String securitiesId);
    //修改
    public int updateBond(BondPojo bondPojo);
    //查所有
    public List<BondPojo> selectBond();

}
