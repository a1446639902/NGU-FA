package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.Seate;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

/**
 * @name 戴言露
 * @data 2020/9/4 am
 *券商信息表数据库访问接口类
 */

@Mapper
public interface SeateMapper {
    /**
     * 增加
     * @param seate
     * @return
     */
    @Insert("insert into seate(seateId, seateName, seateType, seateRate, brokersId, seateAddress, seateDesc) values(#{seateId}, #{seateName}, #{seateType}, #{seateRate}, #{brokersId}, #{seateAddress}, #{seateDesc})")
    int seateInsert(Seate seate);

    /**
     * 删除
     * @param seateIdList
     * @return
     */
    public int seateDelete(List seateIdList);

    /**
     * 修改
     * @param seate
     * @return
     */
    @Update("update seate set seateName=#{seateName},seateType=#{seateType}, seateRate=#{seateRate}, brokersId=#{brokersId}, seateAddress=#{seateAddress}, seateDesc=#{seateDesc}")
    int SeateUpdate(Seate seate);


    /**
     * 查询
     * @return
     */
    public void seateSelect(HashMap hashMap);
}
