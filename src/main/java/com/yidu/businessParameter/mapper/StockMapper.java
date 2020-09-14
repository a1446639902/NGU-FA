package com.yidu.businessParameter.mapper;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.pojo.StockPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 用户的dao方法
 * date:2020.9.8
 * @author xbf
 * @version 1.0
 */
@Mapper
public interface StockMapper {
    public int insertStock(StockPojo stockPojo);
    public int deleteStock(String stockId);
    public int updateStock(StockPojo stockPojo);
    public List<SecuritiesPojo>selectStock();
    public List<StockPojo> selectParentStock();
    public List<StockPojo> selectSonStock();
}
