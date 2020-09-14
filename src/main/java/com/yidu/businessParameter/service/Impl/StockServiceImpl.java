package com.yidu.businessParameter.service.Impl;

import com.yidu.businessParameter.mapper.StockMapper;
import com.yidu.businessParameter.pojo.SecuritiesPojo;
import com.yidu.businessParameter.pojo.StockPojo;
import com.yidu.businessParameter.service.StockService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * @type stock的service的实现类
 * @author xbf
 * @date 2020-09-11
 * @version 1.0
 */
@Service
public class StockServiceImpl implements StockService {

    @Resource
    StockMapper stockMapper;

    @Override
    public List<SecuritiesPojo> selectStock() {
        return stockMapper.selectStock();
    }

    @Override
    public List<StockPojo> selectSonStock() {
        return stockMapper.selectSonStock();
    }

    @Override
    public int insertStock(StockPojo stockPojo) {
        int i = stockMapper.insertStock(stockPojo);
        return i;
    }
    //删除
    @Override
    public int deleteStock(String stockId) {
        int i = stockMapper.deleteStock(stockId);
        return i;
    }
    //修改
    @Override
    public int updateStock(StockPojo stockPojo) {
        int i = stockMapper.updateStock(stockPojo);
        return i;
    }

    @Override
    public List<StockPojo> selectParentStock() {
        return stockMapper.selectParentStock();
    }
}
