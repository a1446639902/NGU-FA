package com.yidu.taManage.service;


import com.yidu.taManage.pojo.TaTransaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
/**
 * TA交易数据信息表服务类
 * @author 唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */

@Service
@Transactional

public interface TatransactionService {
    //查询
    Map<String,Object> selectTatransaction(String pageSize, String page,String dateTime,String transactionStatus,String transactionType);
    //增加
    public int insertTatransaction(TaTransaction tatransaction);
    //删除
    public int  deleteTatransaction(String taTransactionId);
    //修改
    public int updataTetransaction(TaTransaction tatransaction);
}
