package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.BondMapper;
import com.yidu.businessParameter.pojo.BondPojo;
import com.yidu.businessParameter.service.BondService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  债券信息表的实现类
 *  @author 唐赈环
 *  @date  2020/09/01 15点32分
 *  @version 版本1.0
 */
@Service
public class BondServiceImpl implements BondService {
    /*@Resource*/
    BondMapper bondMapper;

    //增
    @Override
    public int insertBond(BondPojo bondPojo){
        return  bondMapper.insertBond(bondPojo);

    }
    //删除
    @Override
    public int deleteBond(String securitiesId) {
        return bondMapper.deleteBond(securitiesId);
    }
    //修改
    @Override
    public int updateBond(BondPojo bondPojo) {
        return bondMapper.updateBond(bondPojo);
    }

    //查
    public List<BondPojo> selectBond(){
        List<BondPojo> bondPojoList = new ArrayList<>();
        bondMapper.selectBond();
        return bondPojoList;
    }
}
