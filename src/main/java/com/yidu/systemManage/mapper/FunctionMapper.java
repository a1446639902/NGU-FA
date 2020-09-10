package com.yidu.systemManage.mapper;

import com.yidu.systemManage.pojo.FunctionPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/**
 * 功能的dao层
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
@Mapper
public interface FunctionMapper {
    //查询功能
    void selectFunction(HashMap functionMap);

    //修改功能
    int updateFuction(FunctionPojo functionPojo);
}
