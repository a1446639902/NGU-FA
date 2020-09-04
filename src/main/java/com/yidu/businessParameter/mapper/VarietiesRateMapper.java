package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.VarietiesRatePojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName VarietiesRateMapper
 * @Description: TODO
 * @Author 硠君
 * @Date create in 22:39 2020/9/1
 * @Version 1.0
 **/
@Mapper
public interface VarietiesRateMapper {
    int insertVarietiesRate(VarietiesRatePojo varietiesRatePojo);
    int deleteVarietiesRate(int exchangeName,int rateType);
    int updateVarietiesRate(VarietiesRatePojo varietiesRatePojo);
    void selectVarietiesRate(Map map);
}
