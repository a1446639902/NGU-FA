package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.BondPojo;

import java.util.List;

/**
 * 债券信息表服务类
 * @author 唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
/*@Service*/
public interface BondService {
    //增加
    public int insertBond(BondPojo bondPojo);
    //删除
    public int deleteBond(String securitiesId);
    //修改
    public int updateBond(BondPojo bondPojo);
    //查
    public List<BondPojo> selectBond();

}
