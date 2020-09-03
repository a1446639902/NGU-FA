package com.yidu.taManage.service;

import com.yidu.taManage.pojo.TaTransactionPojo;

import java.util.Map;

/**
 * TA交易数据信息表服务类
 * @author 唐赈环
 * @date  2020/09/01 15点32分
 * @version 版本1.0
 */
/*@Service*/
public interface TaTransactionService {
    //查询
    Map<String,Object> selectTaTransaction(String pageSize, String page);
    //增加
    public int insertTaTransaction(TaTransactionPojo tatransaction);
    //删除
    public void  deleteTaTransaction(int transactionId);
    //修改
    public int updateTaTransaction(TaTransactionPojo tatransaction);
}
