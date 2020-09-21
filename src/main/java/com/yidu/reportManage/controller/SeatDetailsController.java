package com.yidu.reportManage.controller;


import com.yidu.businessData.pojo.TransactionData;
import com.yidu.reportManage.service.SeatDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 
 * 功能描述：席位交易量明细控制层
 * @author dyl
 * 2020年9月19日
 * version 1.0
 */
@RestController
@RequestMapping("seatDetails")
public class SeatDetailsController {
	@Resource
	private SeatDetailsService seatDetailsService;
	
	@RequestMapping("/selectSeatDetails")
	public Object selectSeatDetails(TransactionData transactionData, HttpSession session) {
		System.out.println("transactionData==>"+transactionData);
		return seatDetailsService.selectSeatDetails(transactionData,session);
	}
	
}
