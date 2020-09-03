package com.yidu.permission.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * 数据库工具类Mapper
 * @type: mapper
 * @version: v1.0
 * @author: cai
 * @date: 2020/09/03
 */
@Mapper
public interface DbUtilMapper {
    public void selectTableMaxId(Map map);
}
