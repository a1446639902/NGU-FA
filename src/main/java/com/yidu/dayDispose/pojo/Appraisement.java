package com.yidu.dayDispose.pojo;

/**
 * 
 * 功能描述：金融估值核算系统-日终处理-资产估值-资产估值实体类
 * @author 伍菲云
 * 日期：2020年9月12日下午2:34:16
 * version：1.0
 */
public class Appraisement {

	private String toDay; //估值日期
	private String securitiesId;//证券编号
	private Integer securitiesType; //证券类型（1：债券；2：股票）
	private Double closingPrice;  //股市收盘价格
	private Integer securitiesNum; //证券（债券/股票） 购买的数量
	private Double price; //单位成本
	private Double total; //购买的总价格
	private String fundId;//基金编号
	private Double appraisementVal;//估值增值
	private String dateTime;//交易日期
	private String settlementDate;//结算日期
	private Double totalSum;//交易总金额
	private Integer flag; //1流入  -1流出
	private Double actualMoney;//TA交易实际交易金额
	private Integer transactionType;//TA交易类型
	private String strAppraisement;
	
	/**
	 * 默认构造方法
	 */
	public Appraisement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getSettlementDate() {
		return settlementDate;
	}


	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}


	public Double getTotalSum() {
		return totalSum;
	}


	public void setTotalSum(Double totalSum) {
		this.totalSum = totalSum;
	}


	public Double getActualMoney() {
		return actualMoney;
	}

	public void setActualMoney(Double actualMoney) {
		this.actualMoney = actualMoney;
	}

	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getStrAppraisement() {
		return strAppraisement;
	}

	public void setStrAppraisement(String strAppraisement) {
		this.strAppraisement = strAppraisement;
	}

	public String getToDay() {
		return toDay;
	}
	public void setToDay(String toDay) {
		this.toDay = toDay;
	}
	public Double getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(Double closingPrice) {
		this.closingPrice = closingPrice;
	}
	public Integer getSecuritiesNum() {
		return securitiesNum;
	}
	public void setSecuritiesNum(Integer securitiesNum) {
		this.securitiesNum = securitiesNum;
	}
	public Double getPrice() {
		return price;
	}


	public Double getAppraisementVal() {
		return appraisementVal;
	}


	public String getSecuritiesId() {
		return securitiesId;
	}


	public void setSecuritiesId(String securitiesId) {
		this.securitiesId = securitiesId;
	}


	public void setAppraisementVal(Double appraisementVal) {
		this.appraisementVal = appraisementVal;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	 
	public String getFundId() {
		return fundId;
	}


	public void setFundId(String fundId) {
		this.fundId = fundId;
	}


	public Integer getSecuritiesType() {
		return securitiesType;
	}
	public void setSecuritiesType(Integer securitiesType) {
		this.securitiesType = securitiesType;
	}

	@Override
	public String toString() {
		return "Appraisement [toDay=" + toDay + ", securitiesId=" + securitiesId + ", securitiesType=" + securitiesType
				+ ", closingPrice=" + closingPrice + ", securitiesNum=" + securitiesNum + ", price=" + price
				+ ", total=" + total + ", fundId=" + fundId + ", appraisementVal=" + appraisementVal + ", dateTime="
				+ dateTime + ", settlementDate=" + settlementDate + ", totalSum=" + totalSum + ", flag=" + flag
				+ ", actualMoney=" + actualMoney + ", transactionType=" + transactionType + "]";
	}

	
	
}
