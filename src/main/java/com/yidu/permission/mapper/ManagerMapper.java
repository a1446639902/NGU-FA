package com.yidu.permission.mapper;

import com.yidu.permission.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cai
 */
@Mapper
public interface ManagerMapper {
    public List<Manager> selectManager();
}
