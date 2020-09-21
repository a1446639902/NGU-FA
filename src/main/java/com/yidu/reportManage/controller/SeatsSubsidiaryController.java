package com.yidu.reportManage.controller;


import com.yidu.businessData.pojo.TransactionData;
import com.yidu.reportManage.service.SeatsSubsidiaryService;
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
@RequestMapping("seatsSubsidiary")
public class SeatsSubsidiaryController {
	@Resource
	private SeatsSubsidiaryService seatsSubsidiaryService;
	
	@RequestMapping("/selectSeatsSubsidiary")
	public Object selectSeatsSubsidiary(TransactionData transactionData, HttpSession session) {
		System.out.println("transactionData==>"+transactionData);
		System.err.println(seatsSubsidiaryService.selectSeatsSubsidiary(transactionData,session));
		return seatsSubsidiaryService.selectSeatsSubsidiary(transactionData,session);
	}
	
	
	
}
