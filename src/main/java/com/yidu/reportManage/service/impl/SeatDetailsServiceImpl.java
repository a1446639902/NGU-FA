package com.yidu.reportManage.service.impl;



import com.yidu.businessData.pojo.TransactionData;
import com.yidu.reportManage.mapper.SeatDetailsMapper;
import com.yidu.reportManage.service.SeatDetailsService;
import com.yidu.util.LayuiUtil;
import com.yidu.util.LogAnnotation;


import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 *
 * 功能描述：席位交易量明细实现层
 * @author dyl
 * 2020年9月19日
 * version 1.0
 */
@Service
public class SeatDetailsServiceImpl implements SeatDetailsService {
	@Resource
	private SeatDetailsMapper seatDetailsMapper;
	


	@LogAnnotation(viewName="席位成交量明细",details="查询")
	@Override
	public LayuiUtil selectSeatDetails(TransactionData transactionData, HttpSession session) {
		User user = (User) session.getAttribute("user");
		transactionData.setFundId(transactionData.getFundId());
//		int limit = transactionData.getLimit()*(transactionData.getPage());
//		transactionData.setPage(transactionData.getLimit()*(transactionData.getPage()-1));
//		transactionData.setLimit(limit);
		String where = "";
		if(transactionData.getDateTime()!=null && !transactionData.getDateTime().equals("")) {
			where +=" and dateTime =to_date('"+transactionData.getDateTime()+"','yyyy-MM-dd') ";
		}
		if(transactionData.getSeateId()!=null && !transactionData.getSeateId().equals("")) {
			where +=" and seateId ='"+transactionData.getSeateId()+"'";
		}
		transactionData.setSeateId(where);
		List<TransactionData> seatDetailsList = seatDetailsMapper.selectSeatDetails(transactionData);
		return LayuiUtil.layuiUtils(seatDetailsList.size(), seatDetailsList);
	}
	

}
