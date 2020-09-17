package com.yidu.reportManage.pojo;

/**
 * 戴言露
 * 席位成交量明细表
 * 2020-9-17
 */

public class SeateScheduleOf {
    private String securitiesId;     //证券代码   来自TransactionData表
    private String fundName;         //基金名称   来自Fund表
    private double num;              //交易数量   来自TransactionData表
    private double commission;       //佣金费     来自TransactionData表
    private double transferFee;      //过户费     来自transactionData表
    private double brokerage;        //经手费     来自transactionData表
    private double stampDuty;        //印花税     来自transactionData表
    private double collectionRate;   //征管费     来自transactionData表
    private double totalSum;         //交易金额    来自TransactionData表
    private double actualMoney;      //实付金额    来自Tatransaction

    public SeateScheduleOf(String securitiesId, String fundName, double num, double commission, double transferFee, double brokerage, double stampDuty, double collectionRate, double totalSum, double actualMoney) {
        this.securitiesId = securitiesId;
        this.fundName = fundName;
        this.num = num;
        this.commission = commission;
        this.transferFee = transferFee;
        this.brokerage = brokerage;
        this.stampDuty = stampDuty;
        this.collectionRate = collectionRate;
        this.totalSum = totalSum;
        this.actualMoney = actualMoney;
    }

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(double transferFee) {
        this.transferFee = transferFee;
    }

    public double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(double brokerage) {
        this.brokerage = brokerage;
    }

    public double getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public double getCollectionRate() {
        return collectionRate;
    }

    public void setCollectionRate(double collectionRate) {
        this.collectionRate = collectionRate;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(double actualMoney) {
        this.actualMoney = actualMoney;
    }

    @Override
    public String toString() {
        return "SeateScheduleOf{" +
                "securitiesId='" + securitiesId + '\'' +
                ", fundName='" + fundName + '\'' +
                ", num=" + num +
                ", commission=" + commission +
                ", transferFee=" + transferFee +
                ", brokerage=" + brokerage +
                ", stampDuty=" + stampDuty +
                ", collectionRate=" + collectionRate +
                ", totalSum=" + totalSum +
                ", actualMoney=" + actualMoney +
                '}';
    }
}
