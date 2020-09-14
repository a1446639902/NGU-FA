package com.yidu.permission.mapper;


import com.yidu.permission.pojo.SystemMenu;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 菜单栏的dao接口
 */
@Mapper
public interface SystemMenuMapper {

    public List<SystemMenu> selectSystemMenu(Map<String,String> map);
}
