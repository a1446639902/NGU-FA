package com.yidu.systemManage.mapper;


import com.yidu.systemManage.pojo.Fun;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by: kangshao
 * description: TODO
 * 角色功能持久层
 * create time: 2020/9/8 10:07
 * version number 1.0
  * @Param: null
 * @return
 */
@Mapper
public interface FunMapper {
    public List<Fun> selectFun(int pid, int roleId);
}
