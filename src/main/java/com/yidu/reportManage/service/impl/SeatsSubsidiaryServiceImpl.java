package com.yidu.reportManage.service.impl;



import com.yidu.businessData.pojo.TransactionData;
import com.yidu.reportManage.mapper.SeatsSubsidiaryMapper;
import com.yidu.reportManage.service.SeatsSubsidiaryService;
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
public class SeatsSubsidiaryServiceImpl implements SeatsSubsidiaryService {
	@Resource
	private SeatsSubsidiaryMapper seatsSubsidiaryMapper;
	


	@LogAnnotation(viewName="席位交易量明细",details="查询")
	@Override
	public List<TransactionData> selectSeatsSubsidiary(TransactionData transactionData, HttpSession session) {
		User user = (User) session.getAttribute("user");
		transactionData.setFundId(transactionData.getFundId());
		String where = "";
		if(transactionData.getDateTime()!=null && !transactionData.getDateTime().equals("")) {
			where +=" and t.dateTime =to_date('"+transactionData.getDateTime()+"','yyyy-MM-dd') ";
		}
		transactionData.setSeateId(where);
		List<TransactionData> seatDetailsList = seatsSubsidiaryMapper.selectSeatsSubsidiary(transactionData);
		return seatDetailsList;
	}
	

}
