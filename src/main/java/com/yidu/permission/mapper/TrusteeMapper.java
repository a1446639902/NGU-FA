package com.yidu.permission.mapper;

import com.yidu.permission.pojo.Trustee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cai
 */
@Mapper
public interface TrusteeMapper {
    public List<Trustee> selectTrustee();
}
