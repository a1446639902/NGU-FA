package com.yidu.reportManage.service.impl;

import com.yidu.reportManage.mapper.StatementMarketChangeMapper;
import com.yidu.reportManage.pojo.StatementMarketChangePojo;
import com.yidu.reportManage.service.StatementMarketChangeService;
import com.yidu.util.DateTimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 证券市场变动表
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层的实现类
 * @time 2020/9/20
 **/
@Transactional
@Service
public class StatementMarketChangeServiceImpl implements StatementMarketChangeService {
    @Resource
    StatementMarketChangeMapper statementMarketChangeMapper;

    /**
     * 查询证券市场变动表
     * @param dateTime 日期
     * @return 返回hashMap对象
     */
    @Override
    public HashMap selectStatementMarketChange(String dateTime) {
        //判断dateTime是否为空，为空将今日的日期赋值给dateTime
        if (dateTime==null){
            dateTime = DateTimeUtil.getSystemDateTime("yyyy-MM-dd");
        }
        //调用mapper接口方法
        ArrayList<StatementMarketChangePojo> smcpList = (ArrayList<StatementMarketChangePojo>) statementMarketChangeMapper.selectStatementMarketChange(dateTime);
        int count = smcpList.size();
        //遍历smcpList，计算marketChangeValue，ratio
        for (StatementMarketChangePojo smcpPojo : smcpList) {
            double marketChangeValue=(smcpPojo.getClosingPrice()-smcpPojo.getPrice())/smcpPojo.getPrice();
            //double留5个小数点
            BigDecimal bg = new BigDecimal(marketChangeValue);
            marketChangeValue = bg.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
            smcpPojo.setMarketChangeValue(marketChangeValue);
            double ratio=(smcpPojo.getSecuritiesNum()*smcpPojo.getClosingPrice()/smcpPojo.getNetAssetValue());

            BigDecimal bg1 = new BigDecimal(ratio);
            ratio = bg1.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
            smcpPojo.setRatio(ratio);

        }
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("count",count);
        hashMap.put("list",smcpList);
        return hashMap;
    }
}
