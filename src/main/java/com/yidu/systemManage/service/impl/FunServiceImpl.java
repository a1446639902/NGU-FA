package com.yidu.systemManage.service.impl;


import com.yidu.systemManage.mapper.FunMapper;
import com.yidu.systemManage.pojo.Fun;
import com.yidu.systemManage.service.FunService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by: kangshao
 * description: TODO
 * 功能业务层实现类
 * create time: 2020/9/8 11:31
 * version number 1.0
  * @Param: null
 * @return
 */
@Service
@Transactional
public class FunServiceImpl implements FunService {
    @Resource
    FunMapper funMapper;
    @Override
    public List<Fun> selectFun(int pid, int roleId) {
        //查询父功能集合
        List<Fun> fun = funMapper.selectFun(pid, roleId);
        //遍历父功能集合
        for (Fun fun1 : fun) {
            //查询父功能的子功能集合
            List<Fun> fun2 = funMapper.selectFun(fun1.getId(), roleId);
            //如有此子功能则插入实体类
            if(fun2.size()!=0){
                fun1.setChildren(fun2);
                //遍历子集合，根据是否查询到功能ID来set选中属性
                for (Fun fun3 : fun2) {
                    fun3.setChecked(fun3.getEndowId()==0?false:true);
                }
            }

        }
        return fun;
    }
}
