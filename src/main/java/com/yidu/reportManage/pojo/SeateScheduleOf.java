package com.yidu.reportManage.pojo;

/**
 * 戴言露
 * 席位成交量明细表
 * 2020-9-17
 */

public class SeateScheduleOf {
    private String securitiesId;     //证券代码   来自TransactionData表
    private String fundName;         //基金名称   来自TransactionData表
    private Double num;              //交易数量   来自TransactionData表
    private Double commission;       //佣金费     来自TransactionData表
    private Double transferFee;      //过户费     来自transactionData表
    private Double brokerage;        //经手费     来自transactionData表
    private Double stampDuty;        //印花税     来自transactionData表
    private Double collectionRate;   //征管费     来自transactionData表
    private Double totalSum;         //交易金额    来自TransactionData表
    private Double netReceipts;      //实付金额    来自TransactionData表

    public SeateScheduleOf(String securitiesId, String fundName, Double num, Double commission, Double transferFee, Double brokerage, Double stampDuty, Double collectionRate, Double totalSum, Double netReceipts) {
        this.securitiesId = securitiesId;
        this.fundName = fundName;
        this.num = num;
        this.commission = commission;
        this.transferFee = transferFee;
        this.brokerage = brokerage;
        this.stampDuty = stampDuty;
        this.collectionRate = collectionRate;
        this.totalSum = totalSum;
        this.netReceipts = netReceipts;
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

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Double transferFee) {
        this.transferFee = transferFee;
    }

    public Double getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(Double brokerage) {
        this.brokerage = brokerage;
    }

    public Double getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(Double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Double getCollectionRate() {
        return collectionRate;
    }

    public void setCollectionRate(Double collectionRate) {
        this.collectionRate = collectionRate;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Double getNetReceipts() {
        return netReceipts;
    }

    public void setNetReceipts(Double netReceipts) {
        this.netReceipts = netReceipts;
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
                ", netReceipts=" + netReceipts +
                '}';
    }
}
