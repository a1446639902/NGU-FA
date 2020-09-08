package com.yidu.dayDispose.pojo;

/*
* 收益计提现金利息收入 现金库存关联现金账户实体类
* @Author wufeiyun
* date 2020-9-8
* */
public class RevenueProvision {
    private String accountId;
    private String fundId;
    private String blankCardCode;
    private String accountName;
    private String blankName;
    private int deposit;
    private double cardRate;
    private int procisionDays;
    private String openTime;
    private String endTime;
    private String accountDesc;
    private Double cashBlance;
    private Double interest; //利息
    private String businessDate; //业务日期
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getBlankCardCode() {
        return blankCardCode;
    }

    public void setBlankCardCode(String blankCardCode) {
        this.blankCardCode = blankCardCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBlankName() {
        return blankName;
    }

    public void setBlankName(String blankName) {
        this.blankName = blankName;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public double getCardRate() {
        return cardRate;
    }

    public void setCardRate(double cardRate) {
        this.cardRate = cardRate;
    }

    public int getProcisionDays() {
        return procisionDays;
    }

    public void setProcisionDays(int procisionDays) {
        this.procisionDays = procisionDays;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getAccountDesc() {
        return accountDesc;
    }

    public void setAccountDesc(String accountDesc) {
        this.accountDesc = accountDesc;
    }

    public Double getCashBlance() {
        return cashBlance;
    }

    public void setCashBlance(Double cashBlance) {
        this.cashBlance = cashBlance;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public RevenueProvision() {
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public RevenueProvision(String accountId, String fundId, String blankCardCode, String accountName, String blankName, int deposit, double cardRate, int procisionDays, String openTime, String endTime, String accountDesc, Double cashBlance, Double interest, String businessDate) {
        this.accountId = accountId;
        this.fundId = fundId;
        this.blankCardCode = blankCardCode;
        this.accountName = accountName;
        this.blankName = blankName;
        this.deposit = deposit;
        this.cardRate = cardRate;
        this.procisionDays = procisionDays;
        this.openTime = openTime;
        this.endTime = endTime;
        this.accountDesc = accountDesc;
        this.cashBlance = cashBlance;
        this.interest = interest;
        this.businessDate = businessDate;
    }

    @Override
    public String toString() {
        return "RevenueProvision{" +
                "accountId='" + accountId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", blankCardCode='" + blankCardCode + '\'' +
                ", accountName='" + accountName + '\'' +
                ", blankName='" + blankName + '\'' +
                ", deposit=" + deposit +
                ", cardRate=" + cardRate +
                ", procisionDays=" + procisionDays +
                ", openTime='" + openTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", accountDesc='" + accountDesc + '\'' +
                ", cashBlance=" + cashBlance +
                ", interest=" + interest +
                ", businessDate='" + businessDate + '\'' +
                '}';
    }

}
