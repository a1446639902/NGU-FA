package com.yidu.reportManage.service;

import java.util.HashMap;

/**
 * 证券市场变动表
 * @author 黄志豪
 * @version 1.0
 * @Type 服务层接口
 * @time 2020/9/20
 **/
public interface StatementMarketChangeService {
    public HashMap selectStatementMarketChange(String dateTime);
}
