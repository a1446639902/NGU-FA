package com.yidu.businessParameter.service;

import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.pojo.StockPojo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 股票板块
 * @type 股票板块的service类
 * @author xbf
 * @date 2020-09-11
 * @version 1.0
 */

@Service
public interface StockService {

    public List<SecuritiesPojo> selectStock();

    public int insertStock(StockPojo stockPojo);

    public List<StockPojo> selectSonStock();

    public int deleteStock(String stockId);

    public int updateStock(StockPojo stockPojo);

    public List<StockPojo> selectParentStock();
}
