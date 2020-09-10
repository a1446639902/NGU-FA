package com.yidu.businessDispose.pojo;

/**
 *  TA交易数据表 实体类
 *  @name 唐赈环
 *  @date 2020/09/09
 *  版本 1.0
 */


public class TaSettlement {
    private String taTransactionId;    //TA交易表 FK
    private String dateTime;           //交易日期
    private String fundId;             //FK 基金Id来自基金表
    private double fundNum;            //交易数量
    private String accountId;          //FK 来自现金账户表 现金账户Id
    private double totalMoney;         //总金额
    private double price;              //单价(昨日单位净值)
    private int    transactionType;    //1认购 2申购 3赎回
    private int    transactionStatus;  //1结算 0未结算

    /**
     * 默认构造方法
     */
    public TaSettlement(){}

    public TaSettlement(String taTransactionId, String dateTime, String fundId, double fundNum, String accountId, double totalMoney, double price, int transactionType, int transactionStatus) {
        this.taTransactionId = taTransactionId;
        this.dateTime = dateTime;
        this.fundId = fundId;
        this.fundNum = fundNum;
        this.accountId = accountId;
        this.totalMoney = totalMoney;
        this.price = price;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
    }

    /**
     * 带参构造方法
     * @return
     */

    public String getDateTime() {
        return dateTime;
    }

    public String getTaTransactionId() {
        return taTransactionId;
    }

    public void setTaTransactionId(String taTransactionId) {
        this.taTransactionId = taTransactionId;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }


    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getFundNum() {
        return fundNum;
    }

    public void setFundNum(double fundNum) {
        this.fundNum = fundNum;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public int getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(int transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "TaSettlement{" +
                "taTransactionId='" + taTransactionId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", fundId='" + fundId + '\'' +
                ", fundNum=" + fundNum +
                ", accountId='" + accountId + '\'' +
                ", totalMoney=" + totalMoney +
                ", price=" + price +
                ", transactionType=" + transactionType +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}


