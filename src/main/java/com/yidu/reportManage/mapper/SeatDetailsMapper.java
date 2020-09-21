package com.yidu.reportManage.mapper;

import com.yidu.businessData.pojo.TransactionData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 *
 * 功能描述：席位交易量明细Mapper层
 * @author dyl
 * 2020年9月19日
 * version 1.0
 */
@Mapper
public interface SeatDetailsMapper {
	public List<TransactionData> selectSeatDetails(TransactionData transactionData);
}
