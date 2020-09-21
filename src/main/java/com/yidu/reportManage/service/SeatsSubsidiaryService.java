package com.yidu.reportManage.service;


import com.yidu.businessData.pojo.TransactionData;

import javax.servlet.http.HttpSession;
import java.util.List;
/**
 *
 * 功能描述：席位交易量明细Service层
 * @author dyl
 * 2020年9月19日
 * version 1.0
 */
public interface SeatsSubsidiaryService {

	public List<TransactionData> selectSeatsSubsidiary(TransactionData transactionData, HttpSession session);

}
