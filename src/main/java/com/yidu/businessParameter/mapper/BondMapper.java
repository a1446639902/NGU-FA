package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.Bond;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 债券信息表数据库访问接口
 * @author  唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
@Mapper
public interface BondMapper {
    //查询
    HashMap selectBond(Map map);
    //增加
    public int insertBond(Bond bond);
    //删除
    public int  deleteBond(List securitiesId);
    //修改
    public int updateBond(Bond bond);
}
