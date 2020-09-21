package com.yidu.reportManage.service;

import com.yidu.businessData.pojo.TransactionData;
import com.yidu.util.LayuiUtil;

import javax.servlet.http.HttpSession;
/**
 *
 * 功能描述：席位交易量明细Service层
 * @author dyl
 * 2020年9月19日
 * version 1.0
 */
public interface SeatDetailsService {

	public LayuiUtil selectSeatDetails(TransactionData transactionData, HttpSession session);

}
