package com.yidu.reportManage.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 现金头寸表的service层接口
 * @Mr.Zou
 **/

@Service
@Transactional
public interface AvailableCashPositionTableService {

    public Map<String, Object> selectAvailable(String pageSize, String page, String dateTime);

}
