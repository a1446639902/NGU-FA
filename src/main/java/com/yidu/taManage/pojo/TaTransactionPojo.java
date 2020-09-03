package com.yidu.taManage.pojo;

/**
 *  TA交易数据表 实体类
 *  @name 唐赈环
 *  @date 2020/09/01
 *  版本 1.0
 */
public class TaTransactionPojo {
    private String transactionId;//PK , 交易数据编号 TA202008310001
    private String dateTime;//交易日期
    private String balanceDate;//结算日期
    private String fundId;//FK 基金Id来自基金表
    private double fundNum;//交易数量
    private String accountId;//FK 来自现金账户表 现金账户Id
    private double totalMoney;//总金额
    private double actualMoney;//实际交易金额
    private double price;//单价(昨日单位净值)
    private double cost;//费用
    private double agencies;//代销机构1=建设银行  2=工商银行  3=农业银行
    private double transactionType;//1认购 2申购 3赎回
    private double transactionStatus;//1结算 0未结算

    /**
     * 带参构造方法
     * @param transactionId //PK , 交易数据编号 TA202008310001
     * @param dateTime  //交易日期
     * @param balanceDate   //结算日期
     * @param fundId    //FK 基金Id来自基金表
     * @param fundNum   //交易数量
     * @param accountId //FK 来自现金账户表 现金账户Id
     * @param totalMoney    //总金额
     * @param actualMoney   //实际交易金额
     * @param price //单价(昨日单位净值)
     * @param cost  //费用
     * @param agencies  //代销机构1=建设银行  2=工商银行  3=农业银行
     * @param transactionType   //1认购 2申购 3赎回
     * @param transactionStatus//1结算 0未结算
     */
    public TaTransactionPojo(String transactionId, String dateTime, String balanceDate, String fundId, double fundNum, String accountId, double totalMoney, double actualMoney, double price, double cost, double agencies, double transactionType, double transactionStatus) {
        this.transactionId = transactionId;
        this.dateTime = dateTime;
        this.balanceDate = balanceDate;
        this.fundId = fundId;
        this.fundNum = fundNum;
        this.accountId = accountId;
        this.totalMoney = totalMoney;
        this.actualMoney = actualMoney;
        this.price = price;
        this.cost = cost;
        this.agencies = agencies;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
    }

    /**
     * 默认构造方法
     */
    public TaTransactionPojo() {
    }
    /**
     * SET/GET方法
     * @return
     */
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
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

    public double getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(double actualMoney) {
        this.actualMoney = actualMoney;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getAgencies() {
        return agencies;
    }

    public void setAgencies(double agencies) {
        this.agencies = agencies;
    }

    public double getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(double transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(double transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "TaTransactionPojo{" +
                "transactionId='" + transactionId + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", balanceDate='" + balanceDate + '\'' +
                ", fundId='" + fundId + '\'' +
                ", fundNum=" + fundNum +
                ", accountId='" + accountId + '\'' +
                ", totalMoney=" + totalMoney +
                ", actualMoney=" + actualMoney +
                ", price=" + price +
                ", cost=" + cost +
                ", agencies=" + agencies +
                ", transactionType=" + transactionType +
                ", transactionStatus=" + transactionStatus +
                '}';
    }
}
