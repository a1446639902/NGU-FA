package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.VarietiesRatePojo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName VarietiesRateService
 * @Description: TODO
 * @Author 硠君
 * @Date create in 23:07 2020/9/1
 * @Version 1.0
 **/
@Service
public interface VarietiesRateService {
    int insertVarietiesRate(VarietiesRatePojo varietiesRatePojo);
    int deleteVarietiesRate(String exchangeNames,String rateTypes);
    int updateVarietiesRate(VarietiesRatePojo varietiesRatePojo);
    Map<String,Object> selectVarietiesRate(String pageSize, String page);
}
