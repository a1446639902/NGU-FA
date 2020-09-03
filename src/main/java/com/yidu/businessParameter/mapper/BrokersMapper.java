package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.Brokers;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @name 戴言露
 * @data 2020/9/2 pm
 *券商信息表数据库访问接口类
 */


@Mapper
public interface BrokersMapper {
    /**
     * 增加
     * @param brokers
     * @return
     */
    @Insert("insert into brokers(brokersId,brokersName,brokersInstructions,brokersDesc)values(#{brokersId},#{brokersName},#{brokersInstructions},#{brokersDesc})")
    boolean insert(Brokers brokers);


    /**
     * 删除
     * @param id
     * @return
     */
    @Delete("delete from brokers where brokersId=#{brokersId}")
    boolean delete(String id);


    /**
     * 修改
     * @param brokers
     * @return
     */
    @Update("update brokers set brokersName=#{brokersName},brokersInstructions=#{brokersInstructions},brokersDesc=#{brokersDesc} where brokersId=#{brokersId}")
    boolean update(Brokers brokers);


    /**
     * 查询所有
     * @return
     */
    @Select("select * from brokers")
    List<Brokers> select();
}
